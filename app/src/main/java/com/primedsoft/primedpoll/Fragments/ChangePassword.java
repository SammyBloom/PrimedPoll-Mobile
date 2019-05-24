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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassword extends Fragment {
EditText verifyCodeEdit, newPasswordEdit,verifyPasswordEdit;
    private String verifyCode;
    private String newPassword;
    private String verifyPassword, email;
AppCompatButton done;
    public ChangePassword() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        email = getArguments() != null ? getArguments().getString("email") : null;
        View view =  inflater.inflate(R.layout.fragment_change_password, container, false);
        verifyCodeEdit = view.findViewById(R.id.verify_code);
        newPasswordEdit = view.findViewById(R.id.input_new_password);
        verifyPasswordEdit = view.findViewById(R.id.input_verify_new_password);

done = view.findViewById(R.id.done_button);
done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        passwordChange();
    }
});
        passwordChange();
        return view;
    }

    private void passwordChange() {
        verifyCode = verifyCodeEdit.getText().toString().trim();
        newPassword = newPasswordEdit.getText().toString().trim();
        verifyPassword = verifyPasswordEdit.getText().toString().trim();

        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Data data = new Data(verifyCode, newPassword, verifyPassword);
        apiInterface.changePassword(
                data.getVerifyCode(),
                data.getPassword(),
                data.getConfirmPassword()
        ).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Toast.makeText(getActivity(), response.raw().body().toString(), Toast.LENGTH_SHORT).show(); ;
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    public static ChangePassword newInstance() {
        return new ChangePassword();
    }


}
