package com.example.zingthw.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zingthw.Activity.PlayNhacActivity;
import com.example.zingthw.Adapter.PlayNhacAdapter;
import com.example.zingthw.R;


public class PlayDanhSachCacBaiHatFragment extends Fragment {
    View view;
    RecyclerView recyclerViewplaynhac;
    PlayNhacAdapter playNhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bai_hat, container, false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewPlaybaihat);
        playNhacAdapter = new PlayNhacAdapter(getActivity(), PlayNhacActivity.arrbaihat);
        if(PlayNhacActivity.arrbaihat.size()>0){
            playNhacAdapter = new PlayNhacAdapter(getActivity(), PlayNhacActivity.arrbaihat);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playNhacAdapter);
        }
        return view;
    }
}
