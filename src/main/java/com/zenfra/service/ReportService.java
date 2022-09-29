package com.zenfra.service;

import com.zenfra.dto.CreateColumns;
import com.zenfra.dto.ResponseDto;
import com.zenfra.model.ReportColumns;
import com.zenfra.repository.ReportColumnsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReportService implements ReportServiceImpl {

    @Autowired
    private ReportColumnsRepository repository;

    @Autowired
    private ResponseDto dto;

    @Override
    public ResponseEntity<String> createReport(CreateColumns create) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        ReportColumns columns = mapper.map(create, ReportColumns.class);
        repository.save(columns);
        return new ResponseEntity<>("Created Successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> getReportById(UUID id) throws Exception {
        Optional<ReportColumns> columns = repository.findByUUID(id);
        if (columns.isPresent()) {
            ResponseDto response = ResponseDto.builder()
                    .id(columns.get().getId())
                    .message("Response Success")
                    .build();
            return ResponseEntity.ok(response);
        } else {
            throw new Exception();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> listOfRecords() {
        List<ReportColumns> list=repository.findAll();
        ResponseDto responseDto= ResponseDto.builder()
                .id(list.get(0).getId())
                .message("All Reports Are: ")
                .build();

        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> editReport(CreateColumns columns) {

        return null;
    }
}
