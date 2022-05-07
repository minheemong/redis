package me.hyun.redissample.db;


import org.springframework.stereotype.Repository;

import me.hyun.redissample.beans.Product;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDBRepository {
    private static Map<Long, Product> DB = new HashMap<>();

    static{
        Product product1 = new Product();
        product1.setId(2L);
        product1.setName("엘지 티비");
        product1.setPrice(1200000L);
        DB.put(product1.getId(), product1);

        Product product2 = new Product();
        product2.setId(3L);
        product2.setName("삼성 건조기");
        product2.setPrice(1200000L);
        DB.put(product2.getId(), product2);
    }

    public Product getProduct(Long id){
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        return DB.get(id);
    }

    public boolean putProduct(Product product){
        DB.put(product.getId(), product);
        return true;
    }
}
