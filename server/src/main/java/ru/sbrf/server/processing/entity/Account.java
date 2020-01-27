package ru.sbrf.server.processing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private int balance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client_id;
}
