package com.example.getirdesign.retrofit;

import com.example.getirdesign.entities.CRUDCevap;
import com.example.getirdesign.entities.CartProductsCevap;
import com.example.getirdesign.entities.ProductCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductDaoInterface {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    Call<ProductCevap> allProducts();

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<CRUDCevap> addProductToCart(@Field("yemek_adi") String yemek_adi,
                                     @Field("yemek_resim_adi") String yemek_resim_adi,
                                     @Field("yemek_fiyat") int yemek_fiyat,
                                     @Field("yemek_siparis_adet") int yemek_siparis_adet,
                                     @Field("kullanici_adi") String kullanici_adi);

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<CartProductsCevap> getCartProducts(@Field("kullanici_adi") String kullanici_adi);

}
