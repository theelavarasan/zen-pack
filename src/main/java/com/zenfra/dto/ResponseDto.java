package com.zenfra.dto;

import java.util.List;
import java.util.UUID;

import com.zenfra.model.ReportColumns;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto {
	private UUID id;
	private String reportName;
	private List<ReportColumns> reportColumnsList;
	private ReportColumns reportColumns;
	private String message;
}
