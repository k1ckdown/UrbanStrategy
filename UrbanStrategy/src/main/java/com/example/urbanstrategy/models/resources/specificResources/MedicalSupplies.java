package com.example.urbanstrategy.models.resources.specificResources;


import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

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
