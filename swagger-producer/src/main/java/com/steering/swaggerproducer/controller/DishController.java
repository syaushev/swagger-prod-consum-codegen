package com.steering.swaggerproducer.controller;

import com.steering.swaggerproducer.dto.Dish;
import com.steering.swaggerproducer.repository.DishRepository;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api(value = "Dishes Api", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {
    private final DishRepository dishRepository;

    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getDishByName(@RequestParam(value = "name", required = false) String name) {
        if (name==null) {
            return ResponseEntity.ok(dishRepository.findAll());
        }
        Optional<Dish> dishOptional = dishRepository.findByName(name);
        return dishOptional.map(dish -> ResponseEntity.ok(List.of(dish))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
