package com.steering.swaggerproducer.repository;

import com.steering.swaggerproducer.dto.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DishRepository extends ArrayList<Dish> {
    public DishRepository() {
        this.add(new Dish("Caesar salad", 100));
        this.add(new Dish("Pepperoni pizza", 150));
        this.add(new Dish("Lemonade", 10));
    }

    public List<Dish> findAll() {
        return this;
    }

    public Optional<Dish> findByName(String name) {
        return this.stream().filter(dish -> dish.getName().equals(name))
                .findFirst();
    }
}
