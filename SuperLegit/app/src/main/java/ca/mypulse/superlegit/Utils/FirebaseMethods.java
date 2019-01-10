package ca.mypulse.superlegit.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ca.mypulse.superlegit.ExtraPages.MainActivity;
import ca.mypulse.superlegit.Login.LoginActivity;
import ca.mypulse.superlegit.Login.Register;
import ca.mypulse.superlegit.R;
import ca.mypulse.superlegit.models.User;
import ca.mypulse.superlegit.models.UserAccountSetting;

public class FirebaseMethods {

    private static final String TAG = "FirebaseMethods";

    private FirebaseAuth mAuth;
    private Context mcontext;
    private String userID;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myref;


    public FirebaseMethods(Context context){
        mAuth = FirebaseAuth.getInstance();
        mcontext = context;
        firebaseDatabase = FirebaseDatabase.getInstance();
        myref = firebaseDatabase.getReference();
        if(mAuth.getCurrentUser() != null){
            userID = mAuth.getCurrentUser().getUid();
        }
    }


    public void createAccount(String email, String password) {
        Log.d(TAG, "create account: creating account");

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.v(TAG, "createUserWithEmail:success");
                    userID = mAuth.getCurrentUser().getUid();
                    sendVerificationEmail();
                    Log.d(TAG, "onComplete: Authstate changed: " + userID);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(mcontext, "Registration Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.v(TAG, "signInWithEmail:success");
                    userID = mAuth.getCurrentUser().getUid();
                    Log.v(TAG, "onComplete: Authstate changed: " + userID);

                    FirebaseUser user = mAuth.getCurrentUser();
                    try{
                        if(user != null && user.isEmailVerified()){
                            Log.d(TAG, "onComplete success. email is verified");
                            Intent intent = new Intent (mcontext, Main2Activity.class);
                            mcontext.startActivity(intent);
                        }else{
                            Toast.makeText(mcontext, "Email is not verified \n check your email inbox.", Toast.LENGTH_SHORT).show();
                        }
                    }catch(NullPointerException e){
                        Log.e(TAG, "onComplete: Null pointer exception: " + e.getMessage());
                    }

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(mcontext, "Sign In failed.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void getCurrentUser(FirebaseUser user) {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
        }
    }


    public void addNewUser (String email, String birthday, String name, String profile_photo, String education, String job){
        User user = new User (email, userID);
        myref.child(mcontext.getString(R.string.dbname_user))
                .child(userID)
                .setValue(user);

        UserAccountSetting setting = new UserAccountSetting(birthday, education, 0, 0, 0, job, name, profile_photo);
        myref.child(mcontext.getString(R.string.dbname_user_account_setting))
                .child(userID)
                .setValue(setting);
    }

    public void sendVerificationEmail(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            user.sendEmailVerification()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){

                            }else{
                                Toast.makeText(mcontext, "Couldn't send email verification", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

}
