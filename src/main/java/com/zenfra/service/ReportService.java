package com.zenfra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.zenfra.dto.AddReportColumnsRequest;
import com.zenfra.dto.DeleteReportColumnsRequest;
import com.zenfra.dto.GetReportColumnsRequest;
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

			reportColumns.setAliasName(addReportColumnsRequest.getAliasName());
			reportColumns.setCategorySeq(addReportColumnsRequest.getCategorySeq());
			reportColumns.setColumnName(addReportColumnsRequest.getColumnName());
			reportColumns.setDataType(addReportColumnsRequest.getDataType());
			reportColumns.setDbFieldName(addReportColumnsRequest.getDbFieldName());
			reportColumns.setDevices(addReportColumnsRequest.getDevices());
			reportColumns.setDeviceType(addReportColumnsRequest.getDeviceType());
			reportColumns.setHide(addReportColumnsRequest.isHide());
			reportColumns.setId(addReportColumnsRequest.getId());
			reportColumns.setIsSizeMetrics(addReportColumnsRequest.getIsSizeMetrics());
			reportColumns.setPinned(addReportColumnsRequest.isPinned());
			reportColumns.setReportBy(addReportColumnsRequest.getReportBy());
			reportColumns.setReportName(addReportColumnsRequest.getReportName());
			reportColumns.setSeq(addReportColumnsRequest.getSeq());
			reportColumns.setSubCategorySeq(addReportColumnsRequest.getSubCategorySeq());
			reportColumns.setTaskListSubCategory(addReportColumnsRequest.getTaskListSubCategory());
			reportColumns.setTaskListCategory(addReportColumnsRequest.getTaskListCategory());
			reportColumns = reportColumnsRepository.save(reportColumns);

			return ReportColumnsResponseDto.builder().id(reportColumns.getId()).build();
		} catch (Exception e) {
			throw new ZenfraException(HttpStatus.BAD_REQUEST,
					"Input ------ > "
							+ ReportColumnsResponseDto.builder().reportColumns(reportColumns).build().toString()
							+ "::  error" + " ----- > " + e );
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
		ReportColumns reportColumns2 = reportColumns.get();

		try {
			reportColumns2.setAliasName(updateReportColumnsRequest.getAliasName());
			reportColumns2.setCategorySeq(updateReportColumnsRequest.getCategorySeq());
			reportColumns2.setColumnName(updateReportColumnsRequest.getColumnName());
			reportColumns2.setDataType(updateReportColumnsRequest.getDataType());
			reportColumns2.setDbFieldName(updateReportColumnsRequest.getDbFieldName());
			reportColumns2.setDevices(updateReportColumnsRequest.getDevices());
			reportColumns2.setDeviceType(updateReportColumnsRequest.getDeviceType());
			reportColumns2.setHide(updateReportColumnsRequest.isHide());
			reportColumns2.setId(updateReportColumnsRequest.getId());
			reportColumns2.setIsSizeMetrics(updateReportColumnsRequest.getIsSizeMetrics());
			reportColumns2.setPinned(updateReportColumnsRequest.isPinned());
			reportColumns2.setReportBy(updateReportColumnsRequest.getReportBy());
			reportColumns2.setReportName(updateReportColumnsRequest.getReportName());
			reportColumns2.setSeq(updateReportColumnsRequest.getSeq());
			reportColumns2.setSubCategorySeq(updateReportColumnsRequest.getSubCategorySeq());
			reportColumns2.setTaskListSubCategory(updateReportColumnsRequest.getTaskListSubCategory());
			reportColumns2.setTaskListCategory(updateReportColumnsRequest.getTaskListCategory());
			reportColumns2 = reportColumnsRepository.save(reportColumns2);

			return ReportColumnsResponseDto.builder().id(reportColumns2.getId()).build();
		} catch (Exception e) {

			throw new ZenfraException(HttpStatus.BAD_REQUEST,
					"Input ------ > "
							+ ReportColumnsResponseDto.builder().reportColumns(reportColumns2).build().toString()
							+ "::  error" + " ----- > " + e);
		}
	}

	public ReportColumnsResponseDto getReportColumnsById(GetReportColumnsRequest getReportColumnsRequest)
			throws ZenfraException {

		try {
			Optional<ReportColumns> reportColumns = reportColumnsRepository.findById(getReportColumnsRequest.getId());

			return ReportColumnsResponseDto.builder().reportColumns(reportColumns.get()).build();

		} catch (Exception e) {

			throw new ZenfraException(HttpStatus.BAD_REQUEST,
					"Input ------ > "
							+ ReportColumnsResponseDto.builder().id(getReportColumnsRequest.getId()).build().toString()
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
		return ReportColumnsResponseDto.builder().message("Delete Successfully").build();

	}

}
