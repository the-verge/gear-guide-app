package com.verge.testutils;

import com.verge.dto.AmplifierInfo;
import com.verge.dto.GuitarInfo;
import com.verge.dto.ManufacturerInfo;
import com.verge.entity.Amplifier;
import com.verge.entity.Guitar;
import com.verge.entity.Manufacturer;

public final class TestUtils {

    public static final String DESCRIPTION = "description";
    public static final String PICKUPS = "pickups";
    public static final String VALVES = "valves";
    public static final String IMG_SRC = "http://web-server/image.png";
    public static final String IMAGE = "image.png";
    public static final String GIBSON = "Gibson";
    public static final Long GIBSON_ID = 4L;
    public static final Double SCALE = 24.75;

    private TestUtils() {
    }

    public static Guitar createGuitar(String manufacturer, String model) {
        Guitar guitar = new Guitar();
        guitar.setId(1L);
        guitar.setManufacturer(createManufacturer(manufacturer));
        guitar.setModel(model);
        guitar.setDescription(DESCRIPTION);
        guitar.setPickups(PICKUPS);
        guitar.setScale(SCALE);
        return guitar;
    }

    public static GuitarInfo createGuitarInfo(String manufacturer, String model) {
        GuitarInfo guitarInfo = new GuitarInfo();
        guitarInfo.setId(1L);
        guitarInfo.setManufacturer(createManufacturerInfo(manufacturer));
        guitarInfo.setModel(model);
        guitarInfo.setDescription(DESCRIPTION);
        guitarInfo.setPickups(PICKUPS);
        guitarInfo.setScale(SCALE);
        guitarInfo.setImage(IMAGE);
        return guitarInfo;
    }

    public static Amplifier createAmplifier(String manufacturer, String model) {
        Amplifier amplifier = new Amplifier();
        amplifier.setId(2L);
        amplifier.setManufacturer(createManufacturer(manufacturer));
        amplifier.setModel(model);
        amplifier.setDescription(DESCRIPTION);
        amplifier.setValves(VALVES);
        return amplifier;
    }

    public static AmplifierInfo createAmplifierInfo(String manufacturer, String model) {
        AmplifierInfo amplifierInfo = new AmplifierInfo();
        amplifierInfo.setId(2L);
        amplifierInfo.setManufacturer(createManufacturerInfo(manufacturer));
        amplifierInfo.setModel(model);
        amplifierInfo.setDescription(DESCRIPTION);
        amplifierInfo.setValves(VALVES);
        amplifierInfo.setImage(IMAGE);
        return amplifierInfo;
    }

    public static Manufacturer createManufacturer(String name) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(4L);
        manufacturer.setName(name);
        return manufacturer;
    }

    public static ManufacturerInfo createManufacturerInfo(String name) {
        return new ManufacturerInfo(4L, name);
    }
}
