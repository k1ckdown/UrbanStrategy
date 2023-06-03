package com.example.urbanstrategy;

import com.example.urbanstrategy.city.City;
import com.example.urbanstrategy.city.interfaces.ICityController;

public final class GameController {
    private final ICityController city;

    public GameController() {
        this.city = new City();
    }

    public void startGame() {
        city.startSimulate();
    }

    public void addCustomBuilding() {

    }


}
