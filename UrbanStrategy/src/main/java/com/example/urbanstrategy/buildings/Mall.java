package com.example.urbanstrategy.buildings;

import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.resources.Electricity;
import com.example.urbanstrategy.resources.Furniture;

import java.util.List;
import java.util.Map;

public class Mall extends Building {

    public Mall(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "mall", "", "", logisticMediator, Map.of(
                new Furniture(50), List.of(new ConsumeResourceStrategy()),
                new Electricity(1000), List.of(new ConsumeResourceStrategy())
        ));
    }

}
