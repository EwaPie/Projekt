package com.projekt.model;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class DinnerToOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer count;

    @ManyToOne
    private Dinner dinner;

    @ManyToOne
    private Order order;
}
