package com.zenfra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenfra.model.ReportColumns;

@Repository
public interface ReportColumnsRepository extends JpaRepository<ReportColumns, Integer> {

	List<ReportColumns> findByColumnName(String columnName);
}