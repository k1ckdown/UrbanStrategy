package com.example.urbanstrategy.buildings.defaultBuildings;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.resources.*;

import java.util.List;
import java.util.Map;

public final class House extends Building {


    public House(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city,"house", "", "", logisticMediator, Map.of(
                new MedicalSupplies(), List.of(new ConsumeResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Food(), List.of(new ConsumeResourceStrategy()),
                new Waste(), List.of(new ProduceResourceStrategy()),
                new Dish(), List.of(new ConsumeResourceStrategy())
        ));
    }



}
