package com.primedsoft.primedpoll.Activities;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.primedsoft.primedpoll.Adapter.AddInterestAdapter;
import com.primedsoft.primedpoll.Models.Data;
import com.primedsoft.primedpoll.Models.Interest;
import com.primedsoft.primedpoll.R;
import com.primedsoft.primedpoll.api.ApiInterface;
import com.primedsoft.primedpoll.api.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewInterest extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AddInterestAdapter adapter;
    private String token;
    private ArrayList<Interest> datalist = new ArrayList<>();
    FloatingActionButton fab;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_interest);
        token = getIntent().getStringExtra("token");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading......");
        progressDialog.show();
//        startAPiService();
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<ArrayList<Interest>> call = service.allInterest(token);
call.enqueue(new Callback<ArrayList<Interest>>() {
    @Override
    public void onResponse(Call<ArrayList<Interest>> call, Response<ArrayList<Interest>> response) {
progressDialog.dismiss();
generateInterestList(response.body());    }

    @Override
    public void onFailure(Call<ArrayList<Interest>> call, Throwable t) {
progressDialog.dismiss();
    }
});

    }

    private void generateInterestList(ArrayList<Interest> interestArrayList) {
        recyclerView = findViewById(R.id.add_new_interest_recycler);

        adapter = new AddInterestAdapter(interestArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AddNewInterest.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

//    private void startAPiService() {
//        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
//        recyclerView = findViewById(R.id.add_new_interest_recycler);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddNewInterest.this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);

//        getList(service);
//        fab = findViewById(R.id.floatingActionButton);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Goals.this, AddGoals.class);
//                intent.putExtra("fabToken", token);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private ArrayList<Interest> getList(ApiInterface service) {
//       Call<Data> call = service.allInterest(token);
//       call.enqueue(new Callback<Data>() {
//           @Override
//           public void onResponse(Call<Data> call, Response<Data> response) {
//               progressDialog.dismiss();
//               Interest interest = new Interest();
//               Log.e("response--------", response.raw().body().toString());
//               if (datalist != null) {
//                   datalist = response.body().getData().getInterestArrayList();
//                   adapter = new AddInterestAdapter(datalist);
//                   recyclerView.setAdapter(adapter);
//                   adapter.notifyDataSetChanged();
//                   adapter.notifyItemRemoved(Integer.parseInt(interest.getId()));
//               }
//           }
//
//           @Override
//           public void onFailure(Call<Data> call, Throwable t) {
//               progressDialog.dismiss();
//t.getMessage();
//           }
//       });
//        return datalist;
//
//
//    }
}