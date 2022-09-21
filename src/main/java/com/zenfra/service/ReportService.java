package com.zenfra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenfra.dto.AddReportColumns;
import com.zenfra.dto.ReportColumnsResponseDto;
import com.zenfra.dto.UpdateReportColumns;
import com.zenfra.model.ReportColumns;
import com.zenfra.repository.ReportColumnsRepository;

@Service
public class ReportService {

	@Autowired
	private ReportColumnsRepository reportColumnsRepository;

	public ReportColumnsResponseDto insertReportColumns(AddReportColumns addReportColumns) {

		ReportColumns reportColumns = new ReportColumns();
		reportColumns.setAliasName(addReportColumns.getAliasName());
		reportColumns.setCategorySeq(addReportColumns.getCategorySeq());
		reportColumns.setColumnName(addReportColumns.getColumnName());
		reportColumns.setDataType(addReportColumns.getDataType());
		reportColumns.setDbFieldName(addReportColumns.getDbFieldName());
		reportColumns.setDevices(addReportColumns.getDevices());
		reportColumns.setDeviceType(addReportColumns.getDeviceType());
		reportColumns.setHide(addReportColumns.isHide());
		reportColumns.setId(addReportColumns.getId());
		reportColumns.setIsSizeMetrics(addReportColumns.getIsSizeMetrics());
		reportColumns.setPinned(addReportColumns.isPinned());
		reportColumns.setReportBy(addReportColumns.getReportBy());
		reportColumns.setReportName(addReportColumns.getReportName());
		reportColumns.setSeq(addReportColumns.getSeq());
		reportColumns.setSubCategorySeq(addReportColumns.getSubCategorySeq());
		reportColumns.setTaskListSubCategory(addReportColumns.getTaskListSubCategory());
		reportColumns.setTaskListCategory(addReportColumns.getTaskListCategory());
		reportColumns = reportColumnsRepository.save(reportColumns);
		return ReportColumnsResponseDto.builder().id(reportColumns.getId()).build();
	}

	public ReportColumnsResponseDto getReportColumns() {

		List<ReportColumns> reportColumnsList = new ArrayList<>();
		reportColumnsList = reportColumnsRepository.findAll();
		return ReportColumnsResponseDto.builder().reportColumnsList(reportColumnsList).build();
	}

	public ReportColumnsResponseDto editReportColumns(UpdateReportColumns updateReportColumns) {

		Optional<ReportColumns> reportColumns = reportColumnsRepository.findById(updateReportColumns.getId());

		ReportColumns reportColumns2 = reportColumns.get();
		reportColumns2.setAliasName(updateReportColumns.getAliasName());
		reportColumns2.setCategorySeq(updateReportColumns.getCategorySeq());
		reportColumns2.setColumnName(updateReportColumns.getColumnName());
		reportColumns2.setDataType(updateReportColumns.getDataType());
		reportColumns2.setDbFieldName(updateReportColumns.getDbFieldName());
		reportColumns2.setDevices(updateReportColumns.getDevices());
		reportColumns2.setDeviceType(updateReportColumns.getDeviceType());
		reportColumns2.setHide(updateReportColumns.isHide());
		reportColumns2.setId(updateReportColumns.getId());
		reportColumns2.setIsSizeMetrics(updateReportColumns.getIsSizeMetrics());
		reportColumns2.setPinned(updateReportColumns.isPinned());
		reportColumns2.setReportBy(updateReportColumns.getReportBy());
		reportColumns2.setReportName(updateReportColumns.getReportName());
		reportColumns2.setSeq(updateReportColumns.getSeq());
		reportColumns2.setSubCategorySeq(updateReportColumns.getSubCategorySeq());
		reportColumns2.setTaskListSubCategory(updateReportColumns.getTaskListSubCategory());
		reportColumns2.setTaskListCategory(updateReportColumns.getTaskListCategory());
		reportColumns2 = reportColumnsRepository.save(reportColumns2);

		return ReportColumnsResponseDto.builder().id(reportColumns2.getId()).build();
	}

}
