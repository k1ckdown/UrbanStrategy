package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public final class MedicalSupplies extends Resource {

    public MedicalSupplies() {
        super(
                "medical supplies",
                List.of(ProcessingMethodType.PRODUCE),
                ResourceType.MEDICAL_SUPPLIES
        );
    }
}
