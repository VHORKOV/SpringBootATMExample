package ru.sbrf.server.processing;

import lombok.Value;

import java.util.List;

@Value
public class Client {
    private final int clientId;
    private final int PIN;
    private final List<Account> account;
}
