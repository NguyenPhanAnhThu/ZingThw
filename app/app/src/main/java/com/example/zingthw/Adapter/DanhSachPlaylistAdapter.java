package com.example.zingthw.Adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingthw.Activity.DanhSachBaiHatActivity;
import com.example.zingthw.Model.Playlist;
import com.example.zingthw.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachPlaylistAdapter extends RecyclerView.Adapter<DanhSachPlaylistAdapter.ViewHolder> {
    Context context;
    ArrayList<Playlist> arrplaylist;

    public DanhSachPlaylistAdapter(Context context, ArrayList<Playlist> arrplaylist) {
        this.context = context;
        this.arrplaylist = arrplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_danhsachplaylist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = arrplaylist.get(position);
        Picasso.with(context).load(playlist.getHinhNen()).into(holder.imghinhnen);
        holder.txttenplaylist.setText(playlist.getTen());

    }

    @Override
    public int getItemCount() {
        return arrplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewdanhsachplaylist);
            txttenplaylist = itemView.findViewById(R.id.txtdanhsachplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("itemplaylist", arrplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
