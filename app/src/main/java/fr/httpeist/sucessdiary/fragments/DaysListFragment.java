package fr.httpeist.sucessdiary.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.httpeist.sucessdiary.AddDayActivity;
import fr.httpeist.sucessdiary.DAO.DayDAO;
import fr.httpeist.sucessdiary.DayDetailsActivity;
import fr.httpeist.sucessdiary.MainMenuActivity;
import fr.httpeist.sucessdiary.R;
import fr.httpeist.sucessdiary.StartActivity;
import fr.httpeist.sucessdiary.db.LocalConnector;
import fr.httpeist.sucessdiary.db.SQLConnector;
import fr.httpeist.sucessdiary.model.Day;

/**
 * Created by eisti on 25/10/17.
 */

public class DaysListFragment extends Fragment {
    //List of past days + present one
    private ListView daysListView;
    private TextView backFromLevelSelect;
    private TextView addDayTextView;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.days_list_fragment_layout, container, false);

        //Initializing list view
        daysListView = (ListView) view.findViewById(R.id.daysListView);
        //Initializing text view redirecting back to main page
        backFromLevelSelect = (TextView) view.findViewById(R.id.backFromLevelSelect);
        addDayTextView = (TextView) view.findViewById(R.id.addDayFromLevelSelect);

        //Temp Array List for testing
        final ArrayList<String> dayNamesList = new ArrayList<String>();
        //data access object class instantiation
        final DayDAO dayDAO = new DayDAO();
        //Setting connection mode (local/db)
        dayDAO.setConnector(LocalConnector.getSingleInstance());
        //initializing temp array
        for (Day day : dayDAO.getDaysList()) {
            Log.i("Day Name", day.getName());
            dayNamesList.add(day.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, dayNamesList);

        daysListView.setLongClickable(true);

        daysListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Position", "position");
                //Create day instance to send it to the fragment
                Day day = dayDAO.getDayByName(dayNamesList.get(position));
                DayDetailsFragment.day = day;
                Intent intent = new Intent(getActivity(), DayDetailsActivity.class);
                startActivity(intent);
            }
        });

        daysListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Create day instance to send it to the fragment
                Day day = dayDAO.getDayByName(dayNamesList.get(position));

                dayDAO.removeDay(day);
                Intent intent = new Intent(getActivity(), MainMenuActivity.class);
                startActivity(intent);
                getActivity().finish();

                return true;
            }
        });

        daysListView.setAdapter(arrayAdapter);

        backFromLevelSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
            }
        });

        addDayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddDayActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
