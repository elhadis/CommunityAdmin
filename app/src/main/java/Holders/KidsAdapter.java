package Holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rgbat.communityadmin.R;

public class KidsAdapter extends RecyclerView.ViewHolder {

    public TextView kidName,kidFamilyName,familyName,kidDate;
    public KidsAdapter(@NonNull View itemView) {
        super(itemView);
        kidName = itemView.findViewById(R.id.kid_name);
        kidFamilyName = itemView.findViewById(R.id.kid_family_name);
        familyName = itemView.findViewById(R.id.kid_family_phone);
        kidDate = itemView.findViewById(R.id.kid_date);
    }
}
