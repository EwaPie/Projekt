package com.projekt.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private final String id = UUID.randomUUID().toString();
    @Builder.Default
    private BigDecimal cenaNettoPoRabacie = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal cenaNetto = BigDecimal.ZERO;

    @Getter
    @Builder.Default
    private List<Danie> dania;

}
