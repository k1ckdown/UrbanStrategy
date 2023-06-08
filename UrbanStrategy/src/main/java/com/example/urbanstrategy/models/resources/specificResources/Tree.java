package com.example.urbanstrategy.models.resources.specificResources;


import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Tree extends Resource {

    public Tree() {
        super(
                "Tree",
                List.of(ProcessingMethodType.DESTROY, ProcessingMethodType.TREATMENT),
                ResourceType.TREE
        );
    }

}
