package ru.sbrf.server.processing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clients")
@Data
public class Client {

    @Id
    @GeneratedValue
    private int Id;

    private int PIN;

    @OneToMany(mappedBy = "client_id")
    private Set<Account> accounts;
}
