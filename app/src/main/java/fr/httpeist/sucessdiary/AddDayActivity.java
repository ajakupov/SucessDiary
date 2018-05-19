package fr.httpeist.sucessdiary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.httpeist.sucessdiary.fragments.AddDayFragment;

public class AddDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_day);

        AddDayFragment addDayFragment = new AddDayFragment();

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.add_day_fragment_container) != null) {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments
            if (savedInstanceState != null)
                return;
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            addDayFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.add_day_fragment_container, addDayFragment).
                    commit();
        }
    }
}
