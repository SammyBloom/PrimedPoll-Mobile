package com.primedsoft.primedpoll.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.primedsoft.primedpoll.Models.Data;
import com.primedsoft.primedpoll.R;
import com.primedsoft.primedpoll.api.ApiInterface;
import com.primedsoft.primedpoll.api.RetrofitInstance;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPassword extends Fragment {

AppCompatButton sendButton;
    private String typeEmailHere;
    private EditText typeEmailHereEdit;

    public ResetPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        sendButton = view.findViewById(R.id.send_button);
        typeEmailHereEdit = view.findViewById(R.id.type_email_here);

                sendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        typeEmailHere = typeEmailHereEdit.getText().toString().trim();
                        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
                        final Data data = new Data(typeEmailHere);
                        apiInterface.resetPassword(data.getEmail()).enqueue(new Callback<Data>() {
                            @Override
                            public void onResponse(Call<Data> call, Response<Data> response) {
                                Toast.makeText(getActivity(), "Verify email to change password", Toast.LENGTH_SHORT).show();

                                    ChangePassword nextFrag = new ChangePassword();
                                Bundle args = new Bundle();
                                args.putString("email", data.getEmail());
                                nextFrag.setArguments(args);
                                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.fragment_holder, nextFrag, "findThisFragment")
                                            .addToBackStack(null)
                                            .commit();


                            }

                            @Override
                            public void onFailure(Call<Data> call, Throwable t) {
                                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
        return view;
    }

    public static ResetPassword newInstance() {
        return new ResetPassword();
    }
}
