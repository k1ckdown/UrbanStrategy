package com.example.urbanstrategy.utils;


import com.example.urbanstrategy.models.buildings.BuildingType;
import com.example.urbanstrategy.models.transports.TransportType;
import javafx.scene.image.Image;

import java.io.InputStream;

public final class ImageProvider {

    private ImageProvider() {

    }

    private static class Holder {
        static final ImageProvider INSTANCE = new ImageProvider();
    }

    public static ImageProvider getInstance() {
        return ImageProvider.Holder.INSTANCE;
    }

    public Image getCustomBuildingImage() {
        final InputStream inputStream = getImageStream("custom-building");

        assert inputStream != null;
        return new Image(inputStream);
    }

    public Image getDefaultBuildingImage(BuildingType buildingType) {
        final InputStream inputStream = getImageStream(buildingType.name().toLowerCase());

        assert inputStream != null;
        return new Image(inputStream);
    }

    public Image getTransportImage(TransportType transportType) {
        final InputStream inputStream = getImageStream(transportType.name().toLowerCase());

        assert inputStream != null;
        return new Image(inputStream);
    }

    private InputStream getImageStream(String part) {
        final String imagePath = "/images/" + part + ".png";
        final InputStream imageStream = getClass().getResourceAsStream(imagePath);

        assert imageStream != null;
        return imageStream;
    }
}
