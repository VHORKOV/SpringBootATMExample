package ru.sbrf.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.sbrf.client.dto.BalanceDTO;
import ru.sbrf.client.exception.ATMInternalErrorException;
import ru.sbrf.client.service.ATMService;
import ru.sbrf.server.common.messages.Request;
import ru.sbrf.server.common.messages.RequestTypes;


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

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Request> request = new HttpEntity<>(new Request(1, "{\"clientId\":1,\"accountId\":0,\"pin\":123}", RequestTypes.JSON));

        log.info("request.toString()" + request.toString());
//        Response responce = restTemplate.postForObject(
//                "http://127.0.0.1:8080/hosts/1/clients/"+ clientId, request, Response.class);

        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity("http://127.0.0.1:8080/hosts/1/clients/" + clientId,
                        request, String.class);
        log.info("responseEntityStr.getBody()" + responseEntityStr.getBody());
        return atmService.getClientBalance(clientId, accountId, PIN);
    }
}
