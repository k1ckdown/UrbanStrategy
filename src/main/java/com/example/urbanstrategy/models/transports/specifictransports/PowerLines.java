package com.example.urbanstrategy.models.transports.specifictransports;

import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class PowerLines extends Transport {

    public PowerLines() {
        super(
                Constants.TransportNames.POWER_LINES,
                Constants.TransportCapacity.POWER_LINES,
                TransportType.POWER_LINES
        );
    }

}
