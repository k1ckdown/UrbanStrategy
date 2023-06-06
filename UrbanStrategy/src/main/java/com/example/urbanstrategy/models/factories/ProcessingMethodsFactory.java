package com.example.urbanstrategy.models.factories;

import com.example.urbanstrategy.models.processingMethods.*;
import com.example.urbanstrategy.models.processingMethods.specificMethods.*;

public final class ProcessingMethodsFactory {

    private ProcessingMethodsFactory() {}

    public static ProcessingMethodsFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        static final ProcessingMethodsFactory INSTANCE = new ProcessingMethodsFactory();
    }

    public ResourceProcessingStrategy makeMethod(ProcessingMethodType type) {
        switch (type) {
            case CONSUME:
                return new ConsumeResourceStrategy();
            case PRODUCE:
                return new ProduceResourceStrategy();
            case RECYCLE:
                return new RecycleResourceStrategy();
            case DESTROY:
                return new DestroyResourceStrategy();
            case TREATMENT:
                return new TreatmentResourceStrategy();
        }
        return null;
    }
}
