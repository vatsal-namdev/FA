package com.vatsal.FA.service;

import com.vatsal.FA.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    List<ClientDto> getAllClients();
}
