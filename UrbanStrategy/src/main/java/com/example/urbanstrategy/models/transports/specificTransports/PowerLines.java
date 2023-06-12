package com.example.urbanstrategy.models.transports.specificTransports;

import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class PowerLines extends Transport {

    public PowerLines() {
        super("power lines", 500, TransportType.POWER_LINES);
    }

}
