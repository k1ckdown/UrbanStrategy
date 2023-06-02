package com.example.urbanstrategy.buildings;

import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.resources.Electricity;
import com.example.urbanstrategy.resources.Waste;
import com.example.urbanstrategy.resources.Water;

import java.util.List;
import java.util.Map;

public final class House extends Building {


    public House(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city,"house", "", "", logisticMediator, Map.of(
                new Electricity(2000), List.of(new ConsumeResourceStrategy()),
                new Water(3000), List.of(new ConsumeResourceStrategy()),
                new Waste(0), List.of(new ProduceResourceStrategy())
        ));
    }



}
