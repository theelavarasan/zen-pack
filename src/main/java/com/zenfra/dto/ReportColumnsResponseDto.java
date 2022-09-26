package com.zenfra.dto;

import java.util.List;

import com.zenfra.model.ReportColumns;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReportColumnsResponseDto {
	private String id;
	private String reportName;
	private List<ReportColumns> reportColumnsList;
	private List<AddReportColumnsRequest> addReportColumnsRequests;
	private ReportColumns reportColumns;
}
