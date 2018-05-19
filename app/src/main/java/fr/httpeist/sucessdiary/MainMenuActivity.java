package fr.httpeist.sucessdiary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.httpeist.sucessdiary.fragments.DaysListFragment;
import fr.httpeist.sucessdiary.fragments.ProgressFragment;

public class MainMenuActivity extends AppCompatActivity {
    //activity has two fragments
    //left fragment
    DaysListFragment daysListFragment;
    //right fragment
    ProgressFragment progressFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Initializing fragment classes
        daysListFragment = new DaysListFragment();
        progressFragment = new ProgressFragment();

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if ((findViewById(R.id.days_list_fragment_container) != null)
                && (findViewById(R.id.progress_fragment_container) != null)) {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments
            if (savedInstanceState != null)
                return;

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            daysListFragment.setArguments(getIntent().getExtras());
            progressFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.days_list_fragment_container, daysListFragment).
                    add(R.id.progress_fragment_container, progressFragment).commit();
        }
    }
}
