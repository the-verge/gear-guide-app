package com.verge.utiliities;

import com.verge.dto.BaseGearInfo;

import java.util.List;
import java.util.stream.Collectors;

public class GearUtils {

    public static List<String> getModels(List<? extends BaseGearInfo> dtos) {
        return dtos.stream()
                .map(d -> d.getModel())
                .collect(Collectors.toList());
    }
}
