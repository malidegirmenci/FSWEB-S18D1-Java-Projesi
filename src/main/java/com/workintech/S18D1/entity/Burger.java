package com.workintech.S18D1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jpaburger", schema = "s18")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "is_vegan")
    private Boolean isVegan;
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name = "contents")
    private String contents;
}
