package com.vatsal.FA.service.impl;

import com.vatsal.FA.dto.ProgramDto;
import com.vatsal.FA.entity.Client;
import com.vatsal.FA.entity.Program;
import com.vatsal.FA.mapper.ProgramMapper;
import com.vatsal.FA.mapper.ServiceMapper;
import com.vatsal.FA.repository.ClientRepository;
import com.vatsal.FA.repository.ProgramRepository;
import com.vatsal.FA.repository.ServiceRepository;
import com.vatsal.FA.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private ProgramRepository programRepository;
    private ClientRepository clientRepository;
    private ServiceRepository serviceRepository;

    @Override
    public ProgramDto createProgram(ProgramDto programDto) {
        Client client = clientRepository.findById(programDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + programDto.getClientId()));

        Program program = ProgramMapper.mapToProgram(programDto);
        program.setClient(client);

        List<com.vatsal.FA.entity.Service> services = programDto.getServices().stream()
                .map(serviceDto -> serviceRepository.findById(serviceDto.getId())
                        .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceDto.getId())))
                .collect(Collectors.toList());

        program.setServices(services);

        Program savedProgram = programRepository.save(program);
        return ProgramMapper.mapToProgramDto(savedProgram);
    }

    @Override
    public List<ProgramDto> getAllPrograms() {
        List<Program> programs = programRepository.findAll();
        return programs.stream().map(program -> ProgramMapper.mapToProgramDto(program)).collect(Collectors.toList());
    }
}
