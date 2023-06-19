package com.example.urbanstrategy.models.resources.specificresources;


import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Tree extends Resource {

    public Tree() {
        super(
                Constants.ResourceNames.TREE,
                List.of(ProcessingMethodType.DESTROY, ProcessingMethodType.TREATMENT),
                ResourceType.TREE
        );
    }

}
