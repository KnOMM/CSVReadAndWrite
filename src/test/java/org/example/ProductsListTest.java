package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsListTest {

    @Test
    public void testList(){
        List<Product> productList = List.of(new Product("АТБ", "Гречка", 30.25F, 120));
        Assertions.assertEquals(productList, ProductsList.getProductsList("src/test/java/resources/"));
        Assertions.assertEquals(new ArrayList<>(), ProductsList.getProductsList("src/test/java/resources/emptyFolder"));
    }
}
