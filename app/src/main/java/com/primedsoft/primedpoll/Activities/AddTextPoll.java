package com.primedsoft.primedpoll.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.primedsoft.primedpoll.CreatePoll;
import com.primedsoft.primedpoll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTextPoll extends Fragment {


    public AddTextPoll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_text_poll, container, false);
        AppCompatButton next = view.findViewById(R.id.next_button);
        final EditText textPoll = view.findViewById(R.id.text_poll_edit);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextCount = 4;

                if(textPoll.getText() != null){
                    --nextCount;
                    Toast.makeText(getContext(), "Polls remaining is " + nextCount, Toast.LENGTH_SHORT).show();
                    textPoll.setText("");
                }else{
                    Toast.makeText(getContext(), "Poll cant be empty " + nextCount, Toast.LENGTH_SHORT).show();

                }
                if(nextCount < 0){
                    Toast.makeText(getContext(), "Poll limit reached " + nextCount, Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;

    }
    public static AddTextPoll newInstance() {
        return new AddTextPoll();
    }


}
