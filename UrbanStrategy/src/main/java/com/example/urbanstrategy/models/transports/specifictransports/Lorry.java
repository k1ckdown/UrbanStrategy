package com.example.urbanstrategy.models.transports.specifictransports;

import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class Lorry extends Transport {

    public Lorry() {
        super("lorry", 500, TransportType.LORRY);
    }
}
