package com.vatsal.FA.mapper;

import com.vatsal.FA.dto.ProgramDto;
import com.vatsal.FA.entity.Program;

import java.util.Collections;
import java.util.stream.Collectors;

public class ProgramMapper {

    public static ProgramDto mapToProgramDto(Program program){
        return new ProgramDto(
                program.getId(),
                program.getName(),
                program.getClient() != null ? program.getClient().getId() : null,
                program.getServices() != null
                        ? program.getServices().stream()
                        .map(ServiceMapper::mapToServiceDto)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

    public static Program mapToProgram(ProgramDto programDto){
        Program program = new Program();
        program.setId(program.getId());
        program.setName(programDto.getName());
        program.setServices(programDto.getServices() != null
                ? programDto.getServices().stream()
                .map(ServiceMapper::mapToService)
                .collect(Collectors.toList())
                : Collections.emptyList());

        // Client will be set in the service layer
        return program;
    }
}
