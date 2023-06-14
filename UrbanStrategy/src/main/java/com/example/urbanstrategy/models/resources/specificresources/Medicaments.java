package com.example.urbanstrategy.models.resources.specificresources;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Medicaments extends Resource {

    public Medicaments() {
        super(
                "Medicaments",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.CONSUME),
                ResourceType.MEDICAMENTS
        );
    }
}
