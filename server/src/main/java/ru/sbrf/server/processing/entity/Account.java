package ru.sbrf.server.processing.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private int balance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client_id;
}
