package com.example.urbanstrategy.models.resources.interfaces;

import com.example.urbanstrategy.models.resources.ResourceType;

public interface IResourceTransported {
    void remove(int value);
    int getAmount();
    ResourceType getType();
}
