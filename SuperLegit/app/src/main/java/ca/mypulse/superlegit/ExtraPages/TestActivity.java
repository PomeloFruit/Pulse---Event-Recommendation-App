package ca.mypulse.superlegit.ExtraPages;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import ca.mypulse.superlegit.R;

public class TestActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.foryou:


                                break;

                            case R.id.discovery:



                                break;

                            case R.id.mypulse:



                                break;

                            case R.id.network:



                               break;
                        }
                        return true;
                    }
                });
    }

}
