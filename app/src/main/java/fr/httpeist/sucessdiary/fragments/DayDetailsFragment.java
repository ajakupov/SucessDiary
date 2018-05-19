package fr.httpeist.sucessdiary.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fr.httpeist.sucessdiary.AddDayActivity;
import fr.httpeist.sucessdiary.EditDayActivity;
import fr.httpeist.sucessdiary.R;
import fr.httpeist.sucessdiary.StartActivity;
import fr.httpeist.sucessdiary.model.Day;

/**
 * Created by eisti on 13/11/17.
 */

public class DayDetailsFragment extends Fragment {
    //Text views corresponding to the right column
    private TextView dayDetailsNumber;
    private TextView dayDetailsName;
    private TextView dayDetailsDate;

    //Back to start page
    private TextView backFromDayDetails;

    private Button addDayButton;
    private Button editDayButton;
    private Button getGoalsButton;

    //Static variable to get data from the previous activity
    public static Day day;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day_details_fragment_layout, container, false);

        //Initializing the main table's right column
        dayDetailsDate = (TextView) view.findViewById(R.id.dayDetailsDate);
        dayDetailsName = (TextView) view.findViewById(R.id.dayDetailsName);
        dayDetailsNumber = (TextView) view.findViewById(R.id.dayDetailsNumber);

        //Initializing link
        backFromDayDetails = (TextView) view.findViewById(R.id.backFromDayDetails);

        //Initializing buttons
        addDayButton = (Button) view.findViewById(R.id.addDayButton);
        editDayButton = (Button) view.findViewById(R.id.editDayButton);
        getGoalsButton = (Button) view.findViewById(R.id.getGoalsButton);

        //Putting values in the right column
        dayDetailsDate.setText(day.getDate().toString());
        dayDetailsName.setText(day.getName());
        dayDetailsNumber.setText(""+day.getNumber());

        addDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddDayActivity.class);
                startActivity(intent);
            }
        });

        backFromDayDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
            }
        });

        editDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditDayFragment.day = day;
                Intent intent = new Intent(getActivity(), EditDayActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
