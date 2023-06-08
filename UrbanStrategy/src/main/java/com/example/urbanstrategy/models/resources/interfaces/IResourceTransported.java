package com.example.urbanstrategy.models.resources.interfaces;

import com.example.urbanstrategy.models.resources.ResourceType;

public interface IResourceTransported {
    int getAmount();
    void remove(int value);
    ResourceType getType();
}
