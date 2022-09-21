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

import com.zenfra.dto.AddReportColumns;
import com.zenfra.dto.ReportColumnsResponseDto;
import com.zenfra.dto.UpdateReportColumns;
import com.zenfra.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	String d = "g";

	@PostMapping
	public ResponseEntity<ReportColumnsResponseDto> insertReportColumns(
			@RequestBody AddReportColumns addReportColumns) {

		return new ResponseEntity<>(reportService.insertReportColumns(addReportColumns), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ReportColumnsResponseDto> getReportColumns() {

		return new ResponseEntity<>(reportService.getReportColumns(), HttpStatus.OK);
	}

//	@PutMapping
//	ResponseEntity<ReportColumnsResponseDto> updateReportColumns(@RequestBody UpdateReportColumns updateReportColumns) {
//
//		return new ResponseEntity<>(reportService.editReportColumns(updateReportColumns), HttpStatus.OK);
//	}

}
