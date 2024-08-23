package com.vatsal.FA.service;

import com.vatsal.FA.dto.ProgramDto;

import java.util.List;

public interface ProgramService {

    ProgramDto createProgram(ProgramDto programDto);

    List<ProgramDto> getAllPrograms();
}
