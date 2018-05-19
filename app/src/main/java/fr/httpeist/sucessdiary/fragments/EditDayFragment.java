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

import java.util.Date;

import fr.httpeist.sucessdiary.DAO.DayDAO;
import fr.httpeist.sucessdiary.R;
import fr.httpeist.sucessdiary.StartActivity;
import fr.httpeist.sucessdiary.db.LocalConnector;
import fr.httpeist.sucessdiary.model.Day;

/**
 * Created by eisti on 14/11/17.
 */

public class EditDayFragment extends Fragment {
    private TextView dayEditNumber;
    private EditText dayEditName;
    private EditText dayEditDate;
    private TextView backFromDayEdit;

    //Save button
    private Button saveEditChanges;

    public static Day day;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_day_fragment_layout, container, false);

        //Initializing widgets
        dayEditDate = (EditText) view.findViewById(R.id.dayEditDate);
        dayEditName = (EditText) view.findViewById(R.id.dayEditName);

        //Save button
        saveEditChanges = (Button) view.findViewById(R.id.saveEditChanges);

        //Uneditable values
        dayEditNumber = (TextView) view.findViewById(R.id.dayEditNumber);
        backFromDayEdit = (TextView) view.findViewById(R.id.backFromDayEdit);

        dayEditNumber.setText(day.getNumber());
        dayEditDate.setText(day.getDate());
        dayEditName.setText(day.getName());

        backFromDayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
            }
        });

        saveEditChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editName = dayEditName.getText().toString();
                String editDate = dayEditDate.getText().toString();
                String editNumber = day.getNumber();

                //Creating connector
                DayDAO dayDAO = new DayDAO();
                dayDAO.setConnector(LocalConnector.getSingleInstance());

                for (Day day : dayDAO.getDaysList()) {
                    if (day.getNumber().equals(editNumber)) {
                        day.setDate((new Date()).toString());
                        day.setName(editName);
                    }
                }

                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
