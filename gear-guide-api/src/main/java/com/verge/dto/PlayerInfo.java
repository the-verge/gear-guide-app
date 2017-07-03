package com.verge.dto;


import com.verge.type.HasName;

import java.util.List;

public class PlayerInfo extends Dto implements HasName {

    private Long id;

    private String name;

    private String description;

    private String imgSrc;

    private List<GuitarInfo> guitars;

    private List<AmplifierInfo> amplifiers;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public List<GuitarInfo> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<GuitarInfo> guitars) {
        this.guitars = guitars;
    }

    public List<AmplifierInfo> getAmplifiers() {
        return amplifiers;
    }

    public void setAmplifiers(List<AmplifierInfo> amplifiers) {
        this.amplifiers = amplifiers;
    }
}
