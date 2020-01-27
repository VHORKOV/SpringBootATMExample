package ru.sbrf.server.processing;

import org.springframework.web.bind.annotation.*;
import ru.sbrf.server.common.messages.Request;
import ru.sbrf.server.common.messages.Response;

@RestController
public class HostRestController {

    @GetMapping("/hosts")
    public String getHostsInfo(){
        return "{data: \"1 host available\"}";
    }

    @GetMapping("/hosts/{hostId}")
    public String getHostInfo(@PathVariable Long hostId){
        if (hostId == 1) {
            return "{data: \"Host " + hostId + " ready\"}";
        }else{
            return "{data: \"Host " + hostId + " not ready\"}";
        }
    }

    @GetMapping("/hosts/{hostId}/clients")
    public String getClientsInfo(@PathVariable Long hostId){
        if (hostId == 1) {
            return "{data: \"Host " + hostId + " ready\"}";
        }else{
            return "{data: \"Host " + hostId + " not ready\"}";
        }
    }

    @PostMapping("/hosts/{hostId}/clients/{clientId}")
    public Response getBalance(@PathVariable("hostId") Long hostId,
                               @PathVariable("clientId") Long clientId,
                               @RequestBody Request request){
        if (hostId != 1) {
            throw new RuntimeException("Host " + hostId + " is not ready!");
        }
        return null;
    }
}
