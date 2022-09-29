package com.zenfra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.zenfra.dto.AddReportColumnsRequest;
import com.zenfra.dto.DeleteReportColumnsRequest;
import com.zenfra.dto.ReportColumnsResponseDto;
import com.zenfra.dto.UpdateReportColumnsRequest;
import com.zenfra.exception.ZenfraException;
import com.zenfra.model.ReportColumns;
import com.zenfra.repository.ReportColumnsRepository;

@Service
public class ReportService {

	@Autowired
	private ReportColumnsRepository reportColumnsRepository;

	public ReportColumnsResponseDto insertReportColumns(AddReportColumnsRequest addReportColumnsRequest)
			throws ZenfraException {
		ReportColumns reportColumns = new ReportColumns();
		try {
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			ReportColumns reportColumns1 = mapper.map(addReportColumnsRequest, ReportColumns.class);
			reportColumns = reportColumnsRepository.save(reportColumns1);

			return ReportColumnsResponseDto.builder().id(reportColumns1.getId()).build();
		} catch (Exception e) {
			throw new ZenfraException(HttpStatus.BAD_REQUEST,
					"Input ------ > "
							+ ReportColumnsResponseDto.builder().reportColumns(reportColumns).build().toString()
							+ "::  error" + " ----- > " + e);
		}
	}

	public ReportColumnsResponseDto getReportColumns() {

		List<ReportColumns> reportColumnsList = new ArrayList<>();
		reportColumnsList = reportColumnsRepository.findAll();
		return ReportColumnsResponseDto.builder().reportColumnsList(reportColumnsList).build();

	}

	public ReportColumnsResponseDto editReportColumns(UpdateReportColumnsRequest updateReportColumnsRequest)
			throws ZenfraException {

		Optional<ReportColumns> reportColumns = reportColumnsRepository.findById(updateReportColumnsRequest.getId());
		ReportColumns reportColumns3 = reportColumns.get();

		try {
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			ReportColumns reportColumns1 = mapper.map(updateReportColumnsRequest, ReportColumns.class);
			reportColumns3 = reportColumnsRepository.save(reportColumns1);

			return ReportColumnsResponseDto.builder().id(reportColumns1.getId()).build();
		} catch (Exception e) {

			throw new ZenfraException(HttpStatus.BAD_REQUEST,
					"Input ------ > "
							+ ReportColumnsResponseDto.builder().reportColumns(reportColumns3).build().toString()
							+ "::  error" + " ----- > " + e);
		}
	}

	public ReportColumnsResponseDto getReportColumnsById(String getReportColumnsRequest)
			throws ZenfraException {

		try {
			Optional<ReportColumns> reportColumns = reportColumnsRepository.findById(getReportColumnsRequest);

			return ReportColumnsResponseDto.builder().reportColumns(reportColumns.get()).build();

		} catch (Exception e) {

			throw new ZenfraException(HttpStatus.BAD_REQUEST,
					"Input ------ > "
							+ ReportColumnsResponseDto.builder().id(getReportColumnsRequest).build().toString()
							+ "::  error" + " ----- > " + e);
		}
	}

	public ReportColumnsResponseDto deleteReportColumnsById(DeleteReportColumnsRequest deleteReportColumnsRequest)
			throws ZenfraException {
		try {
			reportColumnsRepository.deleteById(deleteReportColumnsRequest.getId());

			return ReportColumnsResponseDto.builder().id(deleteReportColumnsRequest.getId()).build();

		} catch (Exception e) {

			throw new ZenfraException(HttpStatus.BAD_REQUEST, "Input ------ > "
					+ ReportColumnsResponseDto.builder().id(deleteReportColumnsRequest.getId()).build().toString()
					+ "::  error" + " ----- > " + e);
		}
	}

	public ReportColumnsResponseDto deleteReportColumns() {

		reportColumnsRepository.deleteAll();
		return ReportColumnsResponseDto.builder().message("Deleted Successfully").build();

	}
}


