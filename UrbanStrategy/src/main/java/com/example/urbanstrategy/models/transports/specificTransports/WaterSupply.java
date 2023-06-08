package com.example.urbanstrategy.models.transports.specificTransports;


import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public class WaterSupply extends Transport {

    public WaterSupply() {
        super("water supply", 500, TransportType.WATER_SUPPLY);
    }

}
