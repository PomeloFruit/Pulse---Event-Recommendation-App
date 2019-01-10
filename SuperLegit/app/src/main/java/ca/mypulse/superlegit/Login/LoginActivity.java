package ca.mypulse.superlegit.Login;

import android.content.Context;
import android.content.Intent;
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

import ca.mypulse.superlegit.Utils.FirebaseMethods;
import ca.mypulse.superlegit.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private FirebaseMethods firebaseMethods;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = LoginActivity.this;
        firebaseMethods = new FirebaseMethods(mContext);
        setupFirebaseAuth();
        signInBtn();
    }

    private void setupFirebaseAuth(){
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //user signed in
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

    private void signInBtn (){
        final EditText input1 = (EditText)findViewById(R.id.username);
        final EditText input2 = (EditText)findViewById(R.id.password);

        Button signIn = (Button)findViewById(R.id.signinbutton);
        signIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.v(TAG, "onClick: attemping to log in.");

                String email = input1.getText().toString();
                String password = input2.getText().toString();
                Boolean signin = true;

                if(email.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this, "Please Fill In All Fields.", Toast.LENGTH_SHORT).show();
                    signin = false;
                }

                if(signin){
                    firebaseMethods.signIn(email, password);
                }

            }
        });
    }

    public void register(View view){
        Intent intent = new Intent (this, Register.class);
        startActivity(intent);
    }
}
