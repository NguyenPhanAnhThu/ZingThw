package com.example.zingthw.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.zingthw.Adapter.DanhSachTatCaChuDeAdapter;
import com.example.zingthw.Model.ChuDe;
import com.example.zingthw.R;
import com.example.zingthw.Service.APIService;
import com.example.zingthw.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachTatCaChuDeActivity extends AppCompatActivity {
    RecyclerView recyclerViewallchude;
    Toolbar toolbarallChude;
    DanhSachTatCaChuDeAdapter danhSachTatCaChuDeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_tat_ca_chu_de);
        setControl();
        GetData();
    }
    private void GetData(){
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDe>> callback = dataservice.GetAllChuDe();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> arrChuDe = (ArrayList<ChuDe>) response.body();
               // Log.d("BBB", arrChuDe.get(0).getTenChuDe());
                danhSachTatCaChuDeAdapter = new DanhSachTatCaChuDeAdapter(DanhSachTatCaChuDeActivity.this, arrChuDe);
                recyclerViewallchude.setLayoutManager(new GridLayoutManager(DanhSachTatCaChuDeActivity.this,1));
                recyclerViewallchude.setAdapter(danhSachTatCaChuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }
    private void setControl(){
        recyclerViewallchude = findViewById(R.id.recyclerviewAllchude);
        toolbarallChude = findViewById(R.id.toolbarallchude);
        setSupportActionBar(toolbarallChude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarallChude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
