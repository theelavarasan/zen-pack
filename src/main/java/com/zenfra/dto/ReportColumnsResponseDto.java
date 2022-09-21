package com.zenfra.dto;

import java.util.List;

import com.zenfra.model.ReportColumns;

import lombok.Builder;

@Builder
public class ReportColumnsResponseDto {
	private String id;
	private String reportName;
	private List<ReportColumns> reportColumnsList;
}
