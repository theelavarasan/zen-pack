package com.zenfra.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddReportColumns {

    private String deviceType;
    private String id;
    private String reportName;
    private String dataType;
    private String isSizeMetrics;
    private String seq;
    private String columnName;
    private String reportBy;
    private String dbFieldName;
    private boolean isPinned;
    private String aliasName;
    private String devices;
    private String taskListCategory;
    private Integer categorySeq;
    private Integer subCategorySeq;
    private boolean hide;
    private String taskListSubCategory;


    
}
