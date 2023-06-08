package com.example.urbanstrategy.models.transports.specificTransports;

import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public class PowerLines extends Transport {

    public PowerLines() {
        super("power lines", 2000, TransportType.POWER_LINES);
    }

}
