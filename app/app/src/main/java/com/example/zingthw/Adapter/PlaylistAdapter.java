package com.example.zingthw.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zingthw.Model.Playlist;
import com.example.zingthw.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txttenplaylist;
        ImageView imgbackground, imgplaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.txttenplaylist = convertView.findViewById(R.id.txttenplaylist);
            viewHolder.imgplaylist = convertView.findViewById(R.id.imageviewplaylist);
            viewHolder.imgbackground = convertView.findViewById(R.id.imageviewbackgroundplaylist);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhNen()).into(viewHolder.imgbackground);
        Picasso.with(getContext()).load(playlist.getHinhIcon()).into(viewHolder.imgplaylist);
        viewHolder.txttenplaylist.setText(playlist.getTen());
        return convertView;
    }
}
