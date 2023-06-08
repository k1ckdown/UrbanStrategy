package com.example.urbanstrategy.models.transports.specificTransports;

import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public class Lorry extends Transport {

    public Lorry() {
        super("lorry", 500, TransportType.LORRY);
    }
}
