package com.nooran.noorancoffeeshop.global;

import java.util.ArrayList;
import java.util.List;

import com.nooran.noorancoffeeshop.model.Product;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
