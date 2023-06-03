package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Dish extends Resource{

    public Dish(int amount) {
        super(
                amount,
                "dish",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.CONSUME),
                ResourceType.DISH
        );
    }
}
