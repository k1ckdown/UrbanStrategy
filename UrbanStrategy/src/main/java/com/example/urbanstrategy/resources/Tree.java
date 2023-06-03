package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Tree extends Resource {

    public Tree(int amount) {
        super(
                amount,
                "tree",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.DESTROY, ProcessingMethodType.TREATMENT),
                ResourceType.TREE
        );
    }

}
