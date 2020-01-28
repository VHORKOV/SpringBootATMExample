package ru.sbrf.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.client.dto.BalanceDTO;
import ru.sbrf.client.exception.ATMInternalErrorException;
import ru.sbrf.client.service.ATMService;

@RestController
@AllArgsConstructor
@Log
public class ATMRestController {
    private ATMService atmService;

    @GetMapping("/ATMs")
    public String getATMsStatus() {
        return "1 ATM is ready.";
    }

    @GetMapping("/ATMs/{ATMId}/clients/{clientId}/accounts/{accountId}/{PIN}")
    public BalanceDTO getClientBalance(
            @PathVariable("ATMId") Long ATMId,
            @PathVariable("clientId") Long clientId,
            @PathVariable("accountId") Long accountId,
            @PathVariable("PIN") int PIN) {

        log.info("clientId " + clientId + " accountId " + accountId + " PIN " + PIN);

        if (ATMId != 1) {
            throw new ATMInternalErrorException("ATM internal Error");
        }

        return atmService.getClientBalance(clientId, accountId, PIN);
    }
}
