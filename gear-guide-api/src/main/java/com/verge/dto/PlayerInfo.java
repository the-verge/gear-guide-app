package com.verge.dto;


import java.util.List;

public class PlayerInfo {

    private Long id;

    private String name;

    private String description;

    private String imgSrc;

    private List<GuitarInfo> guitars;

    private List<AmpInfo> amplifiers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<AmpInfo> getAmplifiers() {
        return amplifiers;
    }

    public void setAmplifiers(List<AmpInfo> amplifiers) {
        this.amplifiers = amplifiers;
    }
}
