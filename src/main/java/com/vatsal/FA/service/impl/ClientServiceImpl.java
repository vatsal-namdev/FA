package com.vatsal.FA.service.impl;

import com.vatsal.FA.dto.ClientDto;
import com.vatsal.FA.entity.Client;
import com.vatsal.FA.mapper.ClientMapper;
import com.vatsal.FA.repository.ClientRepository;
import com.vatsal.FA.repository.ServiceRepository;
import com.vatsal.FA.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ServiceRepository serviceRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        List<com.vatsal.FA.entity.Service> services = clientDto.getServices().stream()
                .map(serviceDto -> serviceRepository.findById(serviceDto.getId())
                        .orElseThrow(() -> new RuntimeException("Service not found")))
                        .collect(Collectors.toList());

        client.setServices(services);

        Client savedClient = clientRepository.save(client);

        return ClientMapper.mapToClientDto(savedClient);

    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> ClientMapper.mapToClientDto(client)).collect(Collectors.toList());
    }
}
