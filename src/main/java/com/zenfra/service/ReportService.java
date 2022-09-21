package com.zenfra.service;

import java.util.ArrayList;
import java.util.List;

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

//	public ReportColumnsResponseDto editReportColumns(UpdateReportColumns updateReportColumns) {
//
//		String columnName =updateReportColumns.getId();
//		List<ReportColumns>  reportColumns = reportColumnsRepository.findByColumnName(columnName);
//		reportColumns.add(updateReportColumns);
//		reportColumns = reportColumnsRepository.save(reportColumns);
//		return ReportColumnsResponseDto.builder().id(reportColumns.get(0).  getId()).build();
//	}

}
