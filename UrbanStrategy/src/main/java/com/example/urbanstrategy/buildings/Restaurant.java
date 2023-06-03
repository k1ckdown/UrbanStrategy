package com.example.urbanstrategy.buildings;

import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.processingMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.resources.Dish;
import com.example.urbanstrategy.resources.Food;
import com.example.urbanstrategy.resources.Water;

import java.util.List;
import java.util.Map;

public class Restaurant extends Building  {

    public Restaurant(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "restaurant", "", "", logisticMediator, Map.of(
                new Food(), List.of(new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Dish(), List.of(new ProduceResourceStrategy())
        ));
    }


}
