package com.zenfra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="report_columns",schema = "public")
@Data
public class ReportColumns {
    
    @Column(name="device_type")
    private String deviceType;
    
    @Id 
    @Column(name="report_data_id")
    private String id;
    
    @Column(name="report_name")
    private String reportName;
    
    @Column(name="data_type")
    private String dataType;
    
    @Column(name="is_size_metrics")
    private String isSizeMetrics;
    
    @Column(name="seq")
    private String seq;
    
    @Column(name="column_name")
    private String columnName;
    
    @Column(name="report_by")
    private String reportBy;
    
    @Column(name="db_field_name")
    private String dbFieldName;
    
    @Column(name="is_pinned")
    private boolean isPinned;
    
    @Column(name="alias_name")
    private String aliasName;
    
    @Column(name="devices")
    private String devices;
    
    @Column(name="tasklist_category")
    private String taskListCategory;
    
    @Column(name="category_seq")
    private Integer categorySeq;
    
    @Column(name="sub_category_seq")
    private Integer subCategorySeq;
    
    @Column(name="hide")
    private boolean hide;
    
    @Column(name="takslist_sub_category")
    private String taskListSubCategory;

}
