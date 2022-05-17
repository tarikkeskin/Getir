package com.example.getirdesign.retrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static ProductDaoInterface getProductDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(ProductDaoInterface.class);
    }
}
