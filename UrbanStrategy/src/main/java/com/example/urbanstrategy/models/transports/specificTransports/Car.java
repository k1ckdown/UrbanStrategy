package com.example.urbanstrategy.models.transports.specificTransports;

import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public class Car extends Transport {

    public Car() {
        super("car", 50, TransportType.CAR);
    }

}
