package me.hyun.redissample.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;


@Getter
@Setter
@RedisHash(value = "product", timeToLive = -1L)
public class Product {
    @Id
    private Long id;
    private String name;
    private Long price;
}
