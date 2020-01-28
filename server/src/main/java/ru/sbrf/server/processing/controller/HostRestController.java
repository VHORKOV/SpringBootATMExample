package ru.sbrf.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.server.common.messages.Request;
import ru.sbrf.server.common.messages.Response;
import ru.sbrf.server.processing.ClientDTO;
import ru.sbrf.server.processing.exception.HostNotFoundException;
import ru.sbrf.server.processing.service.ClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@Log
public class HostRestController {

    private ClientService clientService;

    @GetMapping("/hosts")
    public String getHostsInfo() {
        return "{data: \"1 host available\"}";
    }

    @GetMapping("/hosts/{hostId}")
    public String getHostInfo(@PathVariable Long hostId) {
        if (hostId == 1) {
            return "{data: \"Host " + hostId + " ready\"}";
        }else{
            return "{data: \"Host " + hostId + " not ready\"}";
        }
    }

    @GetMapping("/hosts/{hostId}/clients")
    public List<ClientDTO> getClientsInfo(@PathVariable Long hostId) {
        if (hostId != 1) {
            throw new HostNotFoundException();
        }

        return clientService.getAllClients();

    }

    @PostMapping("/hosts/{hostId}/clients/{clientId}")
    public Response getBalance(@PathVariable("hostId") Long hostId,
                               @PathVariable("clientId") Long clientId,
                               @RequestBody Request request) {
        if (hostId != 1) {
            throw new RuntimeException("Host " + hostId + " is not ready!");
        }

        log.info(request.toString());
        Response response = new Response(clientService.getClient(clientId).getAccountDTO().get(0).getBalance());
        log.info(response.toString());
        return response;
    }
}
