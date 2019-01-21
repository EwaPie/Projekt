package com.projekt.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public abstract class Entity {
    // jsf nie radzi sobie z id w formie UUID :/
    private static AtomicInteger ID = new AtomicInteger(0);

    @Builder.Default
    private final Integer id = ID.getAndIncrement();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
