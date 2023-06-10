package com.example.urbanstrategy.models.transports.specificTransports;


import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class Train extends Transport {

    public Train() {
        super("train", 500, TransportType.TRAIN);
    }
}
