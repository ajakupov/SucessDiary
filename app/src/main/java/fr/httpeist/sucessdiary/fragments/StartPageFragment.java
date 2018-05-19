package fr.httpeist.sucessdiary.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.httpeist.sucessdiary.AboutActivity;
import fr.httpeist.sucessdiary.MainMenuActivity;
import fr.httpeist.sucessdiary.R;

/**
 * Created by eisti on 25/10/17.
 */

public class StartPageFragment extends Fragment {
    //button redirecting to the main menu
    private Button startButton;
    //button redirecting to the 'about' page
    private Button aboutButton;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_fragment_layout, container, false);

        //Initializing buttons
        startButton = (Button) view.findViewById(R.id.startButton);
        aboutButton = (Button) view.findViewById(R.id.aboutButton);

        //redirecting to the main menu
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainMenuActivity.class);
                startActivity(intent);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
