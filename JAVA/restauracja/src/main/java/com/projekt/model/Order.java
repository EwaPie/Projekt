package com.projekt.model;

import com.projekt.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@javax.persistence.Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal grossPrice;

    @Builder.Default
    @OneToMany(mappedBy = "order")
    private List<DinnerToOrder> dinner = new ArrayList<>();

    private boolean paid;
    private boolean close;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;



}
