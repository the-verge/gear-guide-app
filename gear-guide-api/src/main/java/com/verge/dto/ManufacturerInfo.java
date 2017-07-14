package com.verge.dto;

import com.verge.type.HasName;

public class ManufacturerInfo implements Dto, HasName {

    private Long id;

    private String name;

    public ManufacturerInfo() {
    }

    public ManufacturerInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
