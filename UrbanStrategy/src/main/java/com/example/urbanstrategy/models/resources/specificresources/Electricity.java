package com.example.urbanstrategy.models.resources.specificresources;


import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Electricity extends Resource {

    public Electricity() {
        super(
                Constants.ResourceNames.ELECTRICITY,
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE),
                ResourceType.ELECTRICITY
        );
    }
}
