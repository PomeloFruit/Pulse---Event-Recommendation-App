package ca.mypulse.superlegit.ExtraPages;

import android.content.Intent;

import java.util.Calendar;
import android.provider.CalendarContract;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Objects;

import ca.mypulse.superlegit.R;
import ca.mypulse.superlegit.Utils.ViewPagerAdapter;

public class EventPage2 extends AppCompatActivity {

    private ViewPager moreEvent;
    private ViewPager organizerEvent;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page2);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setBackgroundDrawable(null);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.translucent)));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageView myImage = (ImageView) findViewById(R.id.eventPic);
        myImage.setAlpha(0.80f);


        moreEvent = (ViewPager) findViewById(R.id.viewPager);
        organizerEvent = (ViewPager) findViewById(R.id.viewPager2);

        viewPagerAdapter = new ViewPagerAdapter(this);
        moreEvent.setAdapter(viewPagerAdapter);
        organizerEvent.setAdapter(viewPagerAdapter);

    }

    public void calendar (View view){
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2019, 0, 19, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2019, 0, 19, 8, 30);
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "Yoga")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
        startActivity(intent);

    }



}
