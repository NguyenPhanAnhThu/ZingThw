package com.example.zingthw.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingthw.Activity.DanhSachTatCaChuDeActivity;
import com.example.zingthw.Activity.DanhSachTheLoaiTheoChuDeActivity;
import com.example.zingthw.Model.ChuDe;
import com.example.zingthw.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachTatCaChuDeAdapter extends  RecyclerView.Adapter<DanhSachTatCaChuDeAdapter.ViewHolder>{
    Context context;
    ArrayList<ChuDe> arrChude;

    public DanhSachTatCaChuDeAdapter(Context context, ArrayList<ChuDe> arrChude) {
        this.context = context;
        this.arrChude = arrChude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_cacchude, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDe chuDe = arrChude.get(position);
        Picasso.with(context).load(chuDe.getHinhChuDe()).into(holder.imgchude);

    }

    @Override
    public int getItemCount() {
        return arrChude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgchude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgchude = itemView.findViewById(R.id.imgviewdongcacchude);
            imgchude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachTheLoaiTheoChuDeActivity.class);
                    intent.putExtra("chude", arrChude.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
