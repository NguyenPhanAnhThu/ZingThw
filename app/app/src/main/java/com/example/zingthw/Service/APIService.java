package com.example.zingthw.Service;

public class APIService {
    private  static String base_url = "https://soundthw.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitCilent.getClient(base_url).create(Dataservice.class);
    }
}
