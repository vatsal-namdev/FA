package com.vatsal.FA.controller;

import com.vatsal.FA.dto.ClientDto;
import com.vatsal.FA.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto){
        ClientDto savedClient = clientService.createClient(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients(){
        List<ClientDto> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }
}
