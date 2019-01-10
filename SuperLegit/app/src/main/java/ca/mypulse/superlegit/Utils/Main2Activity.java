package ca.mypulse.superlegit.Utils;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import ca.mypulse.superlegit.Discover.Discover;
import ca.mypulse.superlegit.ForYou.ForYou;
import ca.mypulse.superlegit.Friends.Friends;
import ca.mypulse.superlegit.Login.LoginActivity;
import ca.mypulse.superlegit.MyPulse.MyPulse;
import ca.mypulse.superlegit.R;

public class Main2Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "Main2Activity";
    private BottomNavigationView bottomNavigationView;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Action Bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setBackgroundDrawable(null);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //Bottom Navigation
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        loadFragment(new ForYou());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        setupFirebaseAuth();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.foryou:
                selectedFragment = new ForYou(); //Fragment 0
                break;

            case R.id.discovery:
                selectedFragment = new Discover(); //Fragment 0
                break;

            case R.id.mypulse:
                selectedFragment = new MyPulse(); //Fragment 0
                break;

            case R.id.network:
                selectedFragment = new Friends(); //Fragment 0
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
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
                    Intent intent = new Intent(Main2Activity.this, LoginActivity.class);
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
