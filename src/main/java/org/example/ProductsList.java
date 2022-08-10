package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductsList {
    public static List<Product> getProductsList(String path) {
        List<Product> productList = new ArrayList<>();
        File file = new File(path);
        if (file.list() == null) return new ArrayList<>();
        for (String fileNames : Objects.requireNonNull(file.list())) {
            if (new File(path + fileNames).isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(path + fileNames))) {
                    String line;
                    line = br.readLine();

                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(";");
                        productList.add(new Product(values));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println(Arrays.toString(productList.toArray()));
        return productList;
    }

    public static List<Product> getShopList(List<Product> productList, String shopName) {
        List<Product> distinguishedList = productList.stream()
                .filter(product -> shopName.equals(product.getMallName())).toList();
        return distinguishedList;
    }

    public static List<Product> getFlattenList(List<Product> productList) {

        Map<String, Product> map = new HashMap<>();

        for (Product product : productList) {
            if (map.containsKey(product.getProductName())) {
                Product current = map.get(product.getProductName());
                int count = (int) productList.stream().filter(o -> o.productName.equals(product.getProductName())).count();
                map.put(product.getProductName(), new Product(current.getMallName(), current.getProductName(),
                        current.getPrice() / count + product.getPrice() / count, current.getAmount() + product.getAmount()));
            } else map.put(product.getProductName(), product);
        }

        List<Product> readyList = map.values().stream().toList();
        return readyList;
    }
}
