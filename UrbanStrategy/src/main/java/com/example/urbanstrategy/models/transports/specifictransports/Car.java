package com.example.urbanstrategy.models.transports.specifictransports;

import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class Car extends Transport {

    public Car() {
        super("car", 250, TransportType.CAR);
    }

}
