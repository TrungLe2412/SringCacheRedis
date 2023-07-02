package com.example.hibernatedemo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "user")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;


}
