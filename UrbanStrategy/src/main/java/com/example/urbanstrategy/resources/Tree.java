package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public final class Tree extends Resource {

    public Tree() {
        super(
                "tree",
                List.of(ProcessingMethodType.DESTROY, ProcessingMethodType.TREATMENT),
                ResourceType.TREE
        );
    }

}
