package com.primedsoft.primedpoll.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.primedsoft.primedpoll.Fragments.AnsweredPolls;
import com.primedsoft.primedpoll.Fragments.FeedFragment;
import com.primedsoft.primedpoll.R;

public class Polls extends AppCompatActivity {
    private ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polls);

//      Creates the adapter that will return a fragment for each of the 2 primary sections of the activity
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

//        Setup the viewPager with the sections adapter
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public static class PlaceholderFragment extends Fragment{

        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment(){
        }

        public static PlaceholderFragment newInstance(int sectionNumber){
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter{

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    FeedFragment feedsFragment = new FeedFragment();
                    return feedsFragment;

                case 1:
                    AnsweredPolls answeredPollsFragment = new AnsweredPolls();
                    return answeredPollsFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "FEEDS";

                case 1:
                    return "ANSWERED POLLS";
            }
            return super.getPageTitle(position);
        }
    }
}
