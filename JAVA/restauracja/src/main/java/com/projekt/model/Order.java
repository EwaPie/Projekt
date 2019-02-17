package com.projekt.model;

import com.projekt.enums.AccountType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "dinners")
@EqualsAndHashCode(exclude = "dinners")
@Entity
@javax.persistence.Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal grossPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<DinnerWrapper> dinners = new ArrayList<>();

    private boolean paid;
    private boolean close;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn
    private Discount discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
    private Table table;

}
