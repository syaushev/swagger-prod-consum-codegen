package com.steering.swaggerconsumer.controller;

import com.steering.restaurant.dishes.api.DishControllerApi;
import com.steering.restaurant.dishes.dto.Dish;
import com.steering.swaggerconsumer.dto.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final DishControllerApi dishControllerApi;

    public OrderController(DishControllerApi dishControllerApi) {
        this.dishControllerApi = dishControllerApi;
    }

    @GetMapping
    public ResponseEntity<Order> getOrderByDishName(@RequestParam("dishName") String dishName) {
        Dish dish = dishControllerApi.getDishByNameUsingGET(dishName)
                .blockFirst();
        if (dish == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new Order(1, "test@test.com", List.of(dish.getName())));
    }
}
