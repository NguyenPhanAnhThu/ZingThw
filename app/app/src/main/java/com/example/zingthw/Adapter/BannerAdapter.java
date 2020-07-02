package com.example.zingthw.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.zingthw.Activity.DanhSachBaiHatActivity;
import com.example.zingthw.Model.QuangCao;
import com.example.zingthw.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> arraylistbanner;

    public BannerAdapter(Context context, ArrayList<QuangCao> arraylistbanner) {
        this.context = context;
        this.arraylistbanner = arraylistbanner;
    }

    @Override
    public int getCount() {
        return arraylistbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_banner, container, false);

        ImageView imgbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitlesongbanner  = view.findViewById(R.id.txttitlebannerbaihat);
        TextView txtnoidung = view.findViewById(R.id.txtnoidung);

        Picasso.with(context).load(arraylistbanner.get(position).getHinhAnh()).into(imgbackgroundbanner);
        Picasso.with(context).load(arraylistbanner.get(position).getHinhBaiHat()).into(imgsongbanner);
        txttitlesongbanner.setText(arraylistbanner.get(position).getTenBaiHat());
        txtnoidung.setText(arraylistbanner.get(position).getNoiDung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("banner", arraylistbanner.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
