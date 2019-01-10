package ca.mypulse.superlegit.ForYou;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ca.mypulse.superlegit.ExtraPages.EventPage2;
import ca.mypulse.superlegit.R;

public class ForYou extends Fragment{

    private ImageView events;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.fragment_foryou, container, false);

        events = (ImageView) view.findViewById(R.id.button2);

        events.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getActivity(), EventPage2.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
