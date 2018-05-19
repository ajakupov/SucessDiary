package fr.httpeist.sucessdiary.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.httpeist.sucessdiary.R;
import fr.httpeist.sucessdiary.StartActivity;

/**
 * Created by eisti on 13/11/17.
 */

public class AboutFragment extends Fragment {
    private TextView backFromAbout;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment_layout, container, false);
        //Text view redirecting back to start page from about activity
        backFromAbout = (TextView) view.findViewById(R.id.backFromAbout);
        
        backFromAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
