package me.hyun.redissample.cache;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.hyun.redissample.beans.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
