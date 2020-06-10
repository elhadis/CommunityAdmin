package Holders;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rgbat.communityadmin.R;

import java.util.Random;

public class HelpsHolder extends RecyclerView.ViewHolder

{
    public TextView tvFullName,tvPhone,tvVisa,tvDate;
    public HelpsHolder(@NonNull View itemView) {
        super(itemView);
        tvFullName = itemView.findViewById(R.id.full_name);
        tvPhone = itemView.findViewById(R.id.phone);
        tvVisa = itemView.findViewById(R.id.visa);
        tvDate = itemView.findViewById(R.id.date);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(255), rnd.nextInt(255),
                rnd.nextInt(255));
        itemView.setBackgroundColor(color);

    }

}
