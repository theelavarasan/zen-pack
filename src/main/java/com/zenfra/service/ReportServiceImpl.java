package com.zenfra.service;

import com.zenfra.dto.CreateColumns;
import com.zenfra.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ReportServiceImpl {
    ResponseEntity<String> createReport(CreateColumns create);

    ResponseEntity<ResponseDto> getReportById(UUID id) throws Exception;

    ResponseEntity<ResponseDto> listOfRecords();

    ResponseEntity<ResponseDto> editReport(CreateColumns columns);
}
