package com.example.urbanstrategy.models.transports.specifictransports;


import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.transports.Transport;
import com.example.urbanstrategy.models.transports.TransportType;

public final class Train extends Transport {

    public Train() {
        super(
                Constants.TransportNames.TRAIN,
                Constants.TransportCapacity.TRAIN,
                TransportType.TRAIN
        );
    }
}
