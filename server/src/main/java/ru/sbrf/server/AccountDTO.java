package ru.sbrf.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AccountDTO {
    private final int accountId;
    private final int balance;
}
