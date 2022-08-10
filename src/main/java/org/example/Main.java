package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/";
        String path2 = "src/test/resources/emptyFolder";
        List<Product> productsList = ProductsList.getProductsList(path);
        System.out.println(productsList);
        System.out.println(ProductsList.getProductsList(path2));
        System.out.println(new ArrayList<>());

        List<Product> atb = ProductsList.getShopList(productsList, "АТБ");
        System.out.println(atb);
        System.out.println(ProductsList.getFlattenList(atb));

        File f = new File("src/main/resources/atb_ord.csv");
        if (f.exists()) f.delete();
        else {
            try (FileWriter fw = new FileWriter("src/main/resources/atb_ord.csv", false)) {


                for (Product p : atb) {
                    fw.write(p.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
