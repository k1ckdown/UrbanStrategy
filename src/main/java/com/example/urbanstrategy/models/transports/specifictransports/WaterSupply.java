package com.example.urbanstrategy.models.transports.specifictransports;


import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class WaterSupply extends Transport {

    public WaterSupply() {
        super(
                Constants.TransportNames.WATER_SUPPLY,
                Constants.TransportCapacity.WATER_SUPPLY,
                TransportType.WATER_SUPPLY
        );
    }

}
