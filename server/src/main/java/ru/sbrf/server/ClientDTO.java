package ru.sbrf.server;

import lombok.Value;
import ru.sbrf.server.AccountDTO;

import java.util.List;

@Value
public class ClientDTO {
    private final int clientId;
    private final int PIN;
    private final List<AccountDTO> accountDTO;
}
