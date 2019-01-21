package com.projekt.dto;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;


@Data
@Builder
public class Stol {

    // jsf nie radzi sobie z id w formie UUID :/
    private static AtomicInteger ID = new AtomicInteger(1);

    @Builder.Default
    private final Integer id = ID.getAndIncrement();

    @Builder.Default
    private Integer iloscMiejsc = 5;

    @Builder.Default
    private Rachunek rachunek = Rachunek.builder().build();

}
