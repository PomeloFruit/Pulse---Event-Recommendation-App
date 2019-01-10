package ca.mypulse.superlegit.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ca.mypulse.superlegit.R;


public class SignOut extends AppCompatActivity{
    private final String TAG = "SignOutFragment";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);
        AppCompatButton signout = (AppCompatButton) findViewById(R.id.signOut);

        //setupFirebaseAuth();
        signout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                mAuth.signOut();
                Toast.makeText(SignOut.this, "Sign out Successful", Toast.LENGTH_SHORT).show();
            }
        });

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
                    Intent intent = new Intent(SignOut.this, LoginActivity.class);
                    startActivity(intent);

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

}



