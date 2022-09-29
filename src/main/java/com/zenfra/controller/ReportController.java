package com.zenfra.controller;

import com.zenfra.dto.CreateColumns;

import com.zenfra.dto.ResponseDto;
import com.zenfra.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ReportController {

	@Autowired
	private ReportServiceImpl reportServiceImpl;

	@PostMapping("/createReport")
	public ResponseEntity<String> createReport(@RequestBody CreateColumns create){
		return	reportServiceImpl.createReport(create);
	}
	@GetMapping("/getReport/{id}")
	public ResponseEntity<ResponseDto> getReportById(@PathVariable UUID id) throws Exception {
		return reportServiceImpl.getReportById(id);
	}
	@GetMapping("/ListReports")
	public ResponseEntity<ResponseDto> getListOfRecords(){
		return reportServiceImpl.listOfRecords();
	}
	@PutMapping("/EditReport")
	public ResponseEntity<ResponseDto> EditReport(@RequestBody CreateColumns columns){
		return reportServiceImpl.editReport(columns);
	}
}
