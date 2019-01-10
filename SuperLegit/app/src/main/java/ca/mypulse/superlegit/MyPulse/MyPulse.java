package ca.mypulse.superlegit.MyPulse;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ca.mypulse.superlegit.R;
import ca.mypulse.superlegit.Settings.Settings;

public class MyPulse extends Fragment{
    private Button settings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.fragment_mypulse, container, false);

        settings = (Button) view.findViewById(R.id.settingsbtn);
        settings.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getActivity(), Settings.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
