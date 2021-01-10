package com.tasks.shoocaltask1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Home extends AppCompatActivity {
    CompositeDisposable compositeDisposable;
    IssueApi api;
    RecyclerView recyclerView;
    Retrofit client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);

        compositeDisposable = new CompositeDisposable();
        client = Client.getInstance();
        api = client.create(IssueApi.class);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(api.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<UserData>>() {
                    @Override
                    public void accept(List<UserData> userData) throws Exception {
                        displayData(userData);
                    }
                }));
    }

    private void displayData(List<UserData> userData) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, userData);
        recyclerView.setAdapter(adapter);
    }
}