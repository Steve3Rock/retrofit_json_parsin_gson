package com.example.stephend.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stephend.adapter.DataAdapter;
import com.example.stephend.model.Contact;
import com.example.stephend.model.Contacts;
import com.example.stephend.service.ApiInterface;
import com.example.stephend.service.ServiceCall;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private RecyclerView recyclerView;
    private DataAdapter adapter;

    private ArrayList<Contact> arrCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }


    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {

        ApiInterface api = ServiceCall.getRetService().create(ApiInterface.class);

        Call<Contacts> call = api.getContacts();

        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                Log.e("Called" ,""+response);

                Contacts con = response.body();
                arrCon = new ArrayList<>(Arrays.asList(con.getContacts()));
                Log.e("ArrSize: ", ""+arrCon.size());

                for(int i = 0; i < arrCon.size(); i++){

                    Log.e("Name: ", ""+arrCon.get(i).getName());
                    Log.e("Address: ", ""+arrCon.get(i).getAddress());
                    Log.e("Mobile: ", ""+arrCon.get(i).getPhone().getMobile());

                }
                adapter = new DataAdapter(arrCon);

                //displaying the string array into listview
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}


