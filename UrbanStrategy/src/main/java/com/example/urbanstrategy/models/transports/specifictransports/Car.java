package com.example.urbanstrategy.models.transports.specifictransports;

import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class Car extends Transport {

    public Car() {
        super(
                Constants.TransportNames.CAR,
                Constants.TransportCapacity.CAR,
                TransportType.CAR
        );
    }

}
