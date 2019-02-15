package com.projekt.model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfSeats;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    private List<Order> orders;

}
