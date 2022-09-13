package controller;

import model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductController {
    public static List<Product> productList=new ArrayList<>();
    public void showProductList(){
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public void addNewProduct(Product product) {
        productList.add(product);
    }

    public int findProductById(String id) {
        int index=-1;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getIdProduct().equals(id)){
                index=i;
            }

        }return  index;
    }

    public void changeProductInformation(int index,String id, String name, double price, int quantity, String description) {
        productList.get(index).setIdProduct(id);
        productList.get(index).setName(name);
        productList.get(index).setPrice(price);
        productList.get(index).setQuantity(quantity);
        productList.get(index).setDescription(description);
    }

    public void deleteProduct(int index) {
        productList.remove(index);
    }

    public void sortIncre() {
        Collections.sort(productList);
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));

        }

    }

    public void sortDecre() {
        Collections.reverse(productList);
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public void findMaxValue() {
        int indexMax=0;
       double maxPrice=productList.get(0).getPrice();
        for (int i = 0; i < productList.size(); i++) {
            if(maxPrice<productList.get(i).getPrice()){
                indexMax=i;
                maxPrice=productList.get(i).getPrice();
            }

        }
        System.out.println(productList.get(indexMax));
    }
}
