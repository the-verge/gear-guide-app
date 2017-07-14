package com.verge.utiliities;

import com.verge.type.HasName;

import java.util.List;
import java.util.stream.Collectors;

public final class PlayerUtils {

    private PlayerUtils() {
    }

    public static <T extends HasName> List<String> getNames(List<T> namedObjects) {
        return namedObjects.stream()
                .map(T::getName)
                .collect(Collectors.toList());
    }

}
