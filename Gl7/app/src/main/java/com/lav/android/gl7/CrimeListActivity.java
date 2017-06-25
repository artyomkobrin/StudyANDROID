package com.lav.android.gl7;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Artsiom_Levaniuk on 6/13/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
        //UUID crimeId = (UUID) getIntent()
            //    .getSerializableExtra(EXTRA_CRIME_ID);
      // return CrimeFragment.newInstance(crimeId);
    }

}
