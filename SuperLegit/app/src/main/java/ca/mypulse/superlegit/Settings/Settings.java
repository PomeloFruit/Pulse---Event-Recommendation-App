package ca.mypulse.superlegit.Settings;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RelativeLayout;

import ca.mypulse.superlegit.ExtraPages.EventPage2;
import ca.mypulse.superlegit.Login.SignOut;
import ca.mypulse.superlegit.R;
import ca.mypulse.superlegit.Utils.SectionStatePagerAdapter;

public class Settings extends AppCompatActivity {

    private Context mContext;

    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    private AppCompatButton pulsecode;
    private AppCompatButton personalize;
    private AppCompatButton payment;
    private AppCompatButton chatbot;
    private AppCompatButton faq;
    private AppCompatButton signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        mContext = Settings.this;

        setButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    public void onClick (View view){
        Intent intent  = new Intent(mContext, EventPage2.class);
        startActivity(intent);
    }

    private void setButtons(){
        pulsecode = (AppCompatButton) findViewById(R.id.pulsecode);
        personalize = (AppCompatButton) findViewById(R.id.personalize);
        payment = (AppCompatButton) findViewById(R.id.payment);
        chatbot = (AppCompatButton) findViewById(R.id.chatbot);
        faq = (AppCompatButton) findViewById(R.id.faq);
        signout = (AppCompatButton) findViewById(R.id.signout);

        pulsecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment = new ;
            }
        });
        personalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment = new ;
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment = new ;
            }
        });
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment = new ;
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment = new ;
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Settings.this, SignOut.class);
                startActivity(intent);
            }
        });
    }

}
