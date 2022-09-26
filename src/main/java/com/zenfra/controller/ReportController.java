package com.zenfra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenfra.dto.AddReportColumnsRequest;
import com.zenfra.dto.GetReportColumnsRequest;
import com.zenfra.dto.ReportColumnsResponseDto;
import com.zenfra.dto.UpdateReportColumnsRequest;
import com.zenfra.exception.ZenfraException;
import com.zenfra.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
 
	@PostMapping
	public ResponseEntity<ReportColumnsResponseDto> insertReportColumns(
			@RequestBody AddReportColumnsRequest addReportColumnsRequest) throws ZenfraException {

		return new ResponseEntity<>(reportService.insertReportColumns(addReportColumnsRequest), HttpStatus.OK);
	}

//	@GetMapping 
//	public ResponseEntity<ReportColumnsResponseDto> getReportColumns() {
//
//		return new ResponseEntity<>(reportService.getReportColumns(), HttpStatus.OK);
//	}

	@GetMapping
	public ResponseEntity<ReportColumnsResponseDto> getReportColumnsById(
			@RequestBody GetReportColumnsRequest getReportColumnsRequest) throws ZenfraException {

		return new ResponseEntity<>(reportService.getReportColumnsById(getReportColumnsRequest), HttpStatus.OK);
	}

	@PutMapping
	ResponseEntity<ReportColumnsResponseDto> updateReportColumns(
			@RequestBody UpdateReportColumnsRequest reportColumnsRequest) {

		return new ResponseEntity<>(reportService.editReportColumns(reportColumnsRequest), HttpStatus.OK);
	}

}
