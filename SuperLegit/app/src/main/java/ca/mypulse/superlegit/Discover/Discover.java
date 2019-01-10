package ca.mypulse.superlegit.Discover;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.mypulse.superlegit.R;

public class Discover extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.fragment_discover, container, false);

        return view;
    }
}
