package com.example.springexploring.dto.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface Mapper<E, D> {
    D map(E entity);

    default D apply(E e) {
        return map(e);
    }
    default List<D> mapList(Collection<? extends E> entities) {
        return entities.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}