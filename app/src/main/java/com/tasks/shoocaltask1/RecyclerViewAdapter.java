package com.tasks.shoocaltask1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    Context context;
    List<UserData> userData;

    public RecyclerViewAdapter(Context context, List<UserData> userData) {
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_adapter, parent, false);
        return new CustomViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        JsonObject user = userData.get(position).getUser();
        holder.id.setText("ID : " + userData.get(position).getId());
        holder.login.setText("Login : " + user.get("login").toString().replace("\"", ""));
        holder.repo.setText("Repository : " + userData.get(position).getRepository_url());
        Log.i(TAG, "onBindViewHolder: login " + user.get("login"));
        if (userData.get(position).getState().equals("open")) {
            Log.i(TAG, "onBindViewHolder: " + userData.get(position).getState());
            holder.state.setChecked(true);
            holder.state.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

}
