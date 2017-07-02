package com.verge.utiliities;

import com.verge.type.HasName;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerUtils {

    public static List<String> getNames(List<? extends HasName> namedObjects) {
        return namedObjects.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());
    }

}
