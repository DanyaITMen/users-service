package com.automarket; // Перевір пакет!

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers") // Таблиця 'drivers'
public class User extends PanacheEntity {

    public String name;
    public String licenseNumber;
    public String email;

    public User() {}
}