package com.tasks.shoocaltask1;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "CustomAdapter";

    TextView id;
    TextView login;
    TextView repo;
    CheckBox state;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        login = itemView.findViewById(R.id.login);
        repo = itemView.findViewById(R.id.repoUrl);
        state = itemView.findViewById(R.id.state);
    }
}
