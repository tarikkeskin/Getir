package com.example.getirdesign.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.getirdesign.entities.Products;
import com.example.getirdesign.entities.SepetYemekler;
import com.example.getirdesign.repository.ProductDaoRepository;

import java.util.List;

public class MainPageFragmentViewModel extends ViewModel {

    private final ProductDaoRepository productDaoRepository = new ProductDaoRepository();

    public MutableLiveData<List<SepetYemekler>> cartProductsList;

    public MainPageFragmentViewModel() {
        getAllCartProducts();
        cartProductsList = productDaoRepository.returnAllCartProductsRepo();
    }

    public void getAllCartProducts(){
        productDaoRepository.getCartProductsRepo("tarik");
    }

    public void removeProductFromCart(int product_id, String user_name){
        productDaoRepository.removeProductFromCartRepo(product_id,user_name);
    }


}
