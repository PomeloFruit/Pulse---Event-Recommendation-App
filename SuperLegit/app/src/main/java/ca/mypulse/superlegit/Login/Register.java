package ca.mypulse.superlegit.Login;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ca.mypulse.superlegit.R;
import ca.mypulse.superlegit.Utils.FirebaseMethods;

public class Register extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myref;
    private static final String TAG = "LoginActivity";
    private FirebaseMethods firebaseMethods;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mContext = Register.this;
        firebaseMethods = new FirebaseMethods(mContext);
        setupFirebaseAuth();
        registerBtn();
    }

    private void setupFirebaseAuth(){
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myref = firebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //user signed in
                    myref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //add new user to the database
                            firebaseMethods.addNewUser(mAuth.getCurrentUser().getEmail()," "," "," "," "," ");
                            Toast.makeText(mContext, "Signup successful. Sending verification email", Toast.LENGTH_SHORT).show();
                            mAuth.signOut();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else{
                    //user is signed out

                }
            }
        };

    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void registerBtn (){
        final EditText input1 = (EditText)findViewById(R.id.username);
        final EditText input2 = (EditText)findViewById(R.id.confirmusername);
        final EditText input3 = (EditText)findViewById(R.id.password);
        final EditText input4 = (EditText)findViewById(R.id.confirmpassword);
        Button register = (Button)findViewById(R.id.registerbutton);

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.v(TAG, "onClick: attemping to register.");

                String email = input1.getText().toString();
                String confirmemail = input2.getText().toString();
                String password = input3.getText().toString();
                String confirmpassword = input4.getText().toString();
                Boolean signup = true;

                if(email.equals("") || password.equals("") || confirmemail.equals("") || confirmpassword.equals("")){
                    Toast.makeText(Register.this, "Please Fill In All Fields.", Toast.LENGTH_SHORT).show();
                    signup = false;
                }
                if(!email.equals(confirmemail)){
                    Toast.makeText(Register.this, "Emails do not match", Toast.LENGTH_SHORT).show();
                    signup = false;
                }
                if(!password.equals(confirmpassword)){
                    Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    signup = false;
                }

                if(signup){
                    firebaseMethods.createAccount(email, password);
                }

            }
        });
    }


}
