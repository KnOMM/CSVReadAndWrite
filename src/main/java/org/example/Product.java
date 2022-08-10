package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    String mallName;
    String productName;
    float price;
    int amount;

    public Product(String[] values) {
        mallName = values[0];
        productName = values[1];
        price = Float.parseFloat(values[2]);
        amount = Integer.parseInt(values[3]);
    }

    @Override
    public String toString() {
        return mallName +
                ";" + productName +
                ";" + price +
                ";" + amount + "\n";
    }
}
