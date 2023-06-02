package com.example.urbanstrategy.buildings;


import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.processingMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.resources.Food;
import com.example.urbanstrategy.resources.Grain;
import com.example.urbanstrategy.resources.Water;

import java.util.List;
import java.util.Map;

public class Farm extends Building {

    public Farm(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "farm", "", "", logisticMediator, Map.of(
                new Grain(0), List.of(new TreatmentResourceStrategy()),
                new Water(500), List.of(new ConsumeResourceStrategy()),
                new Food(0), List.of(new ProduceResourceStrategy())
        ));
    }

}
