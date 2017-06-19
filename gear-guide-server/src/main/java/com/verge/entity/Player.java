package com.verge.entity;

import com.verge.utiliities.HasImg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Player")
public class Player implements HasImg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Player_Guitars",
            joinColumns = {@JoinColumn(name = "player_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "guitar_id", referencedColumnName = "id")})
    private Set<Guitar> guitars;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Player_Amplifiers",
            joinColumns = {@JoinColumn(name = "player_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "amplifier_id", referencedColumnName = "id")})
    private Set<Amplifier> amplifiers;

    public Player() {
    }

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

    @Override
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<Guitar> guitars) {
        this.guitars = guitars;
    }

    public Set<Amplifier> getAmplifiers() {
        return amplifiers;
    }

    public void setAmplifiers(Set<Amplifier> amplifiers) {
        this.amplifiers = amplifiers;
    }
}
