package com.vatsal.FA.mapper;

import com.vatsal.FA.dto.ClientDto;
import com.vatsal.FA.entity.Client;

import java.util.Collections;
import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientDto mapToClientDto(Client client){
        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getServices() != null
                        ? client.getServices().stream()
                        .map(ServiceMapper::mapToServiceDto)
                        .collect(Collectors.toList())
                        : Collections.emptyList(),
                client.getPrograms() != null
                        ? client.getPrograms().stream()
                        .map(ProgramMapper::mapToProgramDto)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

    public static Client mapToClient(ClientDto clientDto){
        return new Client(
                clientDto.getId(),
                clientDto.getName(),
                clientDto.getServices() != null
                        ? clientDto.getServices().stream()
                        .map(ServiceMapper::mapToService)
                        .collect(Collectors.toList())
                        : Collections.emptyList(),
                clientDto.getPrograms() != null
                        ? clientDto.getPrograms().stream()
                        .map(ProgramMapper::mapToProgram)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }
}
