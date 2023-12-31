package com.example.urbanstrategy.models.factories;

import com.example.urbanstrategy.models.transports.*;
import com.example.urbanstrategy.models.transports.specifictransports.*;

import java.util.ArrayList;
import java.util.List;

public final class TransportFactory {

    private TransportFactory() {}

    public static TransportFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        static final TransportFactory INSTANCE = new TransportFactory();
    }

    public List<Transport> makeAllTransports() {
        final List<Transport> transportList = new ArrayList<>();
        final TransportType[] transportTypes = TransportType.values();

        for(TransportType type : transportTypes) {
            transportList.add(makeTransport(type));
        }

        return transportList;
    }

    private Transport makeTransport(TransportType type) {
        switch (type) {
            case CAR:
                return new Car();
            case TRAIN:
                return new Train();
            case LORRY:
                return new Lorry();
            case POWER_LINES:
                return new PowerLines();
            case WATER_SUPPLY:
                return new WaterSupply();
        }
        return null;
    }

}
