package ru.sbrf.lesson.processing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Client {
    private final int clientId;
    private final int PIN;
    private final List<Account> account = new ArrayList<>();
}
