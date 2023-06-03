package com.example.urbanstrategy.buildings;

import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.resources.MedicalSupplies;

import java.util.List;
import java.util.Map;

public class Hospital extends Building {

    public Hospital(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "hospital", "", "", logisticMediator, Map.of(
                new MedicalSupplies(), List.of(new ProduceResourceStrategy())
        ));
    }
}
