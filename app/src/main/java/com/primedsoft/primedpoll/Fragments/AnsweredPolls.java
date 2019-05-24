package com.primedsoft.primedpoll.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.primedsoft.primedpoll.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnsweredPolls extends Fragment {


    public AnsweredPolls() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answered_polls, container, false);
    }

}
