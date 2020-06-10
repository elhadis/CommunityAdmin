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

import java.security.PrivateKey;

import Holders.KidsAdapter;
import Model.KidsInfo;

public class KidsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private Dialog loadingDialog;
    private DatabaseReference Ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        recyclerView = findViewById(R.id.kids_list);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Ref = FirebaseDatabase.getInstance().getReference().child("Kids");

        loadingDialog = new Dialog(KidsActivity.this);
        loadingDialog.setContentView(R.layout.loading_progress);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);



    }

    @Override
    protected void onStart() {
        super.onStart();
        loadingDialog.show();


        FirebaseRecyclerOptions<KidsInfo> options = new FirebaseRecyclerOptions.Builder<KidsInfo>()
                .setQuery(Ref,KidsInfo.class).build();
        FirebaseRecyclerAdapter<KidsInfo, KidsAdapter> adapter = new
                FirebaseRecyclerAdapter<KidsInfo, KidsAdapter>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull KidsAdapter holder, int position, @NonNull KidsInfo model) {

                        holder.kidName.setText( model.getKidName());
                        holder.kidFamilyName.setText( model.getKidFamily());
                        holder.familyName.setText( model.getFamilyNum());
                        holder.kidDate.setText( model.getDat());
                        loadingDialog.dismiss();

                    }

                    @NonNull
                    @Override
                    public KidsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kids_info_layout,
                                parent,false);
                        return new KidsAdapter(view);
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();



    }
}
