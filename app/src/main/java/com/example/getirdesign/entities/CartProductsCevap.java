
package com.example.getirdesign.entities;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CartProductsCevap {

    @SerializedName("sepet_yemekler")
    @Expose
    private List<SepetYemekler> sepetYemekler = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<SepetYemekler> getSepetYemekler() {
        return sepetYemekler;
    }

    public void setSepetYemekler(List<SepetYemekler> sepetYemekler) {
        this.sepetYemekler = sepetYemekler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
