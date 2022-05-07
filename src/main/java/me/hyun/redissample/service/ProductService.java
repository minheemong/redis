package me.hyun.redissample.service;


import lombok.RequiredArgsConstructor;
import me.hyun.redissample.beans.Product;
import me.hyun.redissample.cache.ProductRepository;
import me.hyun.redissample.db.ProductDBRepository;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    //DB
    private final ProductDBRepository productDBRepository;
    //CACHE
    private final ProductRepository productRepository;

    public Product getProduct(Long id){
        //CACHE 에서 검색
        Product product = productRepository.findById(id).orElseGet(
                ()->{
                    System.out.println("CACHE MISS");
                    System.out.println("          GO TO DB");
                    //CACHE에 없으면 DB로 검색
                    Product foundFromDB = productDBRepository.getProduct(id);
                    System.out.println("          BACK FROM DB");
                    //DB에서 가져온 값을 CACHE에 넣음
                    productRepository.save(foundFromDB);
                    System.out.println("SAVE IN CACHE");
                    return foundFromDB;
                }
        );
        return product;
    }
}
