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
    int nextCount = 4;


    public AddTextPoll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_text_poll, container, false);
        AppCompatButton next = view.findViewById(R.id.next_button);
        AppCompatButton cancel = view.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v = inflater.inflate(R.layout.activity_create_poll,container, false);
            }
        });
        final EditText textPoll = view.findViewById(R.id.text_poll_edit);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textPoll.getText() != null){
                    --nextCount;
                    Toast.makeText(getContext(), "Polls remaining is " + nextCount, Toast.LENGTH_SHORT).show();
                    textPoll.setText("");

                }else {
                    textPoll.getText();
                    Toast.makeText(getContext(), "Poll cant be empty " + nextCount, Toast.LENGTH_SHORT).show();

                }
                if(nextCount < 0){
                    Toast.makeText(getContext(), "Poll limit reached " + nextCount, Toast.LENGTH_SHORT).show();
nextCount = 0;
                }

            }
        });
        return view;

    }
    public static AddTextPoll newInstance() {
        return new AddTextPoll();
    }
}
