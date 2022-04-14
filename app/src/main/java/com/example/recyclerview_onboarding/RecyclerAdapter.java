package com.example.recyclerview_onboarding;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    View view;
    LottieAnimationView lottieAnimationView;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false);
        LottieAnimationView lottieAnimationView = view.findViewById(R.id.lottie);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.position_tv.setText("Choose Your Product");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView position_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            position_tv = itemView.findViewById(R.id.position_tv);
        }
    }
}