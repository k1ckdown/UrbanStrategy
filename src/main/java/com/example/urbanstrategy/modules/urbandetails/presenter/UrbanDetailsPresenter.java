package com.example.urbanstrategy.modules.urbandetails.presenter;

import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.modules.buildingeditor.presenter.BuildingEditorPresenter;
import com.example.urbanstrategy.modules.buildingeditor.presenter.BuildingEditorPresenterDelegate;
import com.example.urbanstrategy.modules.buildingeditor.view.BuildingEditorView;
import com.example.urbanstrategy.utils.ImageProvider;
import com.example.urbanstrategy.models.buildings.BuildingType;
import com.example.urbanstrategy.models.buildings.custombuilding.CustomBuildingBuilder;
import com.example.urbanstrategy.models.city.City;
import com.example.urbanstrategy.models.city.interfaces.ICityController;
import com.example.urbanstrategy.models.transports.TransportType;
import com.example.urbanstrategy.modules.urbandetails.view.IUrbanDetailsView;
import javafx.application.Platform;
import javafx.scene.image.Image;

import java.util.List;

public final class UrbanDetailsPresenter
        implements IUrbanDetailsPresenter, BuildingEditorPresenterDelegate {

    private final IUrbanDetailsView view;
    private final BuildingEditorView buildingEditorView;

    private final ICityController cityController;

    private int numberOfColumns;
    private final int numberOfRows = 2;
    private int numberOfCustomBuilding = 0;

    private final List<String> namesTransports;
    private final List<String> namesBuildings;
    private final List<String> descriptionsBuilding;

    private final BuildingType[] buildingTypes =  BuildingType.values();
    private final TransportType[] transportTypes = TransportType.values();

    public UrbanDetailsPresenter(IUrbanDetailsView view, City city) {
        cityController = city;

        namesTransports = cityController.getNamesTransports();
        namesBuildings = cityController.getNamesBuildings();
        descriptionsBuilding = cityController.getDescriptionsBuilding();
        numberOfColumns = buildingTypes.length / numberOfRows;

        buildingEditorView = new BuildingEditorView();
        final BuildingEditorPresenter buildingEditorPresenter = new BuildingEditorPresenter(
                buildingEditorView,
                new CustomBuildingBuilder(city)
        );
        buildingEditorPresenter.delegate = this;

        this.view = view;
        view.setPresenter(this);
    }

    public void launch() {
        cityController.startSimulate();

        Thread playThread = new Thread(() -> {
            while (true) {

                try {
                    Platform.runLater(() -> {
                        updateBuildingInfo();
                        updateTransportInfo();
                    });

                    Thread.sleep(Constants.UPDATE_SLEEP_TIME);
                } catch (Exception error) {
                    throw new RuntimeException(error);
                }

            }
        });

        playThread.start();
    }

    public void didTapOnAddBuildingButton() {
        view.showBuildingEditor(buildingEditorView);
    }

    public void addCustomBuilding(Building customBuilding) {
        cityController.addBuilding(customBuilding);
        numberOfCustomBuilding += 1;

        final int row = (numberOfCustomBuilding - 1) % numberOfRows;
        view.addCustomBuildingCell(
                customBuilding.getName(),
                customBuilding.getDescription(),
                ImageProvider.getInstance().getCustomBuildingImage(),
                row,
                numberOfColumns
        );
        if (row == numberOfRows - 1) {
            numberOfColumns += 1;
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfTransports() {
        return transportTypes.length;
    }

    public String getTransportHeader(int atIndex) {
        return namesTransports.get(atIndex).toUpperCase();
    }

    public String getBuildingHeader(int row, int col) {
        return namesBuildings.get(getBuildingIndex(row, col)).toUpperCase();
    }

    public String getBuildingDesc(int row, int col) {
        return descriptionsBuilding.get(getBuildingIndex(row, col));
    }

    public Image getTransportImage(int atIndex) {
        return ImageProvider.getInstance().getTransportImage(transportTypes[atIndex]);
    }

    public Image getBuildingImage(int row, int col) {
        return ImageProvider.getInstance().getDefaultBuildingImage(buildingTypes[getBuildingIndex(row, col)]);
    }

    private int getBuildingIndex(int row, int col) {
        return row * numberOfColumns + col;
    }

    private void updateTransportInfo() {
        final List<String> transportStatusTitles = cityController.getTransportStatuses();

        for (int i = 0; i < transportStatusTitles.size(); i++) {
            view.updateTransportationStatusTitle(i, transportStatusTitles.get(i));
        }
    }

    private void updateBuildingInfo() {
        final List<String> resourceTitles = cityController.getDescriptionsResourcesOfBuildings();
        final List<String> processingTitles = cityController.getResourceProcessingStatuses();

        for (int i = 0; i < resourceTitles.size(); i++) {
            view.updateResourcesTitle(i, resourceTitles.get(i));
            view.updateProcessingTitle(i, processingTitles.get(i));
        }
    }

}
