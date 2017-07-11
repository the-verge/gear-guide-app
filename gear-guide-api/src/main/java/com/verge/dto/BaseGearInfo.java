package com.verge.dto;

public abstract class BaseGearInfo extends Dto {

    protected Long id;

    protected ManufacturerInfo manufacturer;

    protected String model;

    protected String description;

    protected String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ManufacturerInfo getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerInfo manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
