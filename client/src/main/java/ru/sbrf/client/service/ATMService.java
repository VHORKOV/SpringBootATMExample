package ru.sbrf.client.service;

import org.springframework.stereotype.Service;
import ru.sbrf.client.dto.Balance;

@Service
public class ATMService {

    public Balance getClientBalance(Long clientId, Long accountId, int PIN) {

        return new Balance(10);
    }
}
