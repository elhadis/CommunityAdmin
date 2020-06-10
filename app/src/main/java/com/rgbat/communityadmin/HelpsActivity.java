package com.rgbat.communityadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Holders.HelpsHolder;
import Model.Helps;

public class HelpsActivity extends AppCompatActivity {
    private RecyclerView HelpsList;
    private LinearLayoutManager linearLayoutManager;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helps);
        HelpsList= findViewById(R.id.helps_list);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        HelpsList.setLayoutManager(linearLayoutManager);
        loadingDialog = new Dialog(HelpsActivity.this);
        loadingDialog.setContentView(R.layout.loading_progress);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadingDialog.show();
        DatabaseReference Ref;
        Ref = FirebaseDatabase.getInstance().getReference().child("Helps");
        FirebaseRecyclerOptions<Helps> options = new FirebaseRecyclerOptions.Builder<Helps>()
                .setQuery(Ref,Helps.class).build();
        FirebaseRecyclerAdapter<Helps, HelpsHolder> adapter = new
                FirebaseRecyclerAdapter<Helps, HelpsHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull HelpsHolder holder, int position, @NonNull Helps model) {
                        holder.tvFullName.setText(model.getFullName());
                        holder.tvPhone.setText( model.getPhone());
                        holder.tvVisa.setText(  model.getVisa());
                        holder.tvDate.setText(model.getDate());
                        loadingDialog.dismiss();

                    }

                    @NonNull
                    @Override
                    public HelpsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helps_layout
                        ,parent,false);
                        return new HelpsHolder(view);
                    }
                };
        HelpsList.setAdapter(adapter);
        adapter.startListening();
    }
}
