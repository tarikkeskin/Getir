package com.example.getirdesign.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SepetYemekler {

    @SerializedName("sepet_yemek_id")
    @Expose
    private String sepetYemekId;
    @SerializedName("yemek_adi")
    @Expose
    private String yemekAdi;
    @SerializedName("yemek_resim_adi")
    @Expose
    private String yemekResimAdi;
    @SerializedName("yemek_fiyat")
    @Expose
    private String yemekFiyat;
    @SerializedName("yemek_siparis_adet")
    @Expose
    private String yemekSiparisAdet;
    @SerializedName("kullanici_adi")
    @Expose
    private String kullaniciAdi;

    public String getSepetYemekId() {
        return sepetYemekId;
    }

    public void setSepetYemekId(String sepetYemekId) {
        this.sepetYemekId = sepetYemekId;
    }

    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public String getYemekResimAdi() {
        return yemekResimAdi;
    }

    public void setYemekResimAdi(String yemekResimAdi) {
        this.yemekResimAdi = yemekResimAdi;
    }

    public String getYemekFiyat() {
        return yemekFiyat;
    }

    public void setYemekFiyat(String yemekFiyat) {
        this.yemekFiyat = yemekFiyat;
    }

    public String getYemekSiparisAdet() {
        return yemekSiparisAdet;
    }

    public void setYemekSiparisAdet(String yemekSiparisAdet) {
        this.yemekSiparisAdet = yemekSiparisAdet;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

}
