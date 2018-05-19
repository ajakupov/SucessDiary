package fr.httpeist.sucessdiary.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;
import java.util.Date;

import fr.httpeist.sucessdiary.DAO.DayDAO;
import fr.httpeist.sucessdiary.DayDetailsActivity;
import fr.httpeist.sucessdiary.R;
import fr.httpeist.sucessdiary.StartActivity;
import fr.httpeist.sucessdiary.db.LocalConnector;
import fr.httpeist.sucessdiary.db.SQLConnector;
import fr.httpeist.sucessdiary.model.Day;

/**
 * Created by eisti on 13/11/17.
 */

public class AddDayFragment extends Fragment {
    //link redirecting to start page
    TextView backFromAddDay;

    //User fields
    private EditText editName;
    private EditText editNumber;

    //button to submit values
    private Button addDayButton;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_day_fragment_layout, container, false);

        //Initializing user fields
        editName = (EditText) view.findViewById(R.id.dayNameEntered);
        editNumber = (EditText) view.findViewById(R.id.dayNumberEntered);

        //Initializing link
        backFromAddDay = (TextView) view.findViewById(R.id.backFromAddDay);

        //Initializing submit button
        addDayButton = (Button) view.findViewById(R.id.addNewDayButton);

        //SubmittingValues
        addDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Geting user values
                String editNameValue = editName.getText().toString();
                String editNumberValue = editNumber.getText().toString();

                //Create local connector
                DayDAO dayDAO = new DayDAO();
                dayDAO.setConnector(LocalConnector.getSingleInstance());
                Day day = new Day(editNumberValue, editNameValue, (new Date()).toString());
                if (dayDAO.addDay(day))  {
                    Toast.makeText(getActivity(), "Day added", Toast.LENGTH_SHORT).show();
                    DayDetailsFragment.day = day;

                    Intent intent = new Intent(getActivity(), DayDetailsActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }

            }
        });

        //redirecting
        backFromAddDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
