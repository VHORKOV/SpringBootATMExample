package ru.sbrf.client.service;

import org.springframework.stereotype.Service;
import ru.sbrf.client.dto.BalanceDTO;

@Service
public class ATMService {

    public BalanceDTO getClientBalance(Long clientId, Long accountId, int PIN) {

        return new BalanceDTO(10);
    }
}
