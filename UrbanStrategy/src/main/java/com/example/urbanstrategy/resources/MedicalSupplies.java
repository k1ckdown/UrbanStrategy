package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class MedicalSupplies extends Resource {

    public MedicalSupplies(int amount) {
        super(
                amount,
                "medical supplies",
                List.of(ProcessingMethodType.PRODUCE),
                ResourceType.MEDICAL_SUPPLIES
        );
    }
}
