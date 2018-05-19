package fr.httpeist.sucessdiary.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import fr.httpeist.sucessdiary.R;

/**
 * Created by eisti on 25/10/17.
 */

public class ProgressFragment extends Fragment {
    ImageView progressImageView;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.progress_fragment_layout, container, false);

        return view;
    }
}
