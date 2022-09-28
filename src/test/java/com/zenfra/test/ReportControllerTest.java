package com.zenfra.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenfra.controller.ReportController;
import com.zenfra.dto.AddReportColumnsRequest;
import com.zenfra.dto.GetReportColumnsRequest;
import com.zenfra.dto.ReportColumnsResponseDto;
import com.zenfra.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReportController.class)
public class ReportControllerTest {

    @MockBean
    private ReportService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private AddReportColumnsRequest reportColumns;
    private ReportColumnsResponseDto responseDto;

    private GetReportColumnsRequest columnsRequest;


    @BeforeEach
    void setup(){
        reportColumns=AddReportColumnsRequest.builder()
                .id("1")
                .reportName("Murugan")
                .dataType("data")
                .deviceType("Linux")
                .isSizeMetrics("murugan")
                .seq("jhds")
                .columnName("jsdbhs")
                .reportBy("jgds")
                .dbFieldName("knjsdg")
                .isPinned(true)
                .devices("jhhgsf")
                .aliasName("hagusyd")
                .taskListCategory("jisgcds")
                .taskListSubCategory("jhyasfd")
                .categorySeq(1)
                .subCategorySeq(2)
                .hide(true)
                .build();
    }

    @Test
    void insertReportColumns() throws Exception {
        when(service.insertReportColumns(reportColumns)).thenReturn(responseDto);
        mockMvc.perform(post("/report/insertReportColumns").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reportColumns)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    void getReportsColumnByIdTest() throws Exception {
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDto));
        when(service.getReportColumnsById("1")).thenReturn(responseDto);
        MvcResult result= mockMvc.perform(get("/report/getReportColumnsById")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        assertEquals(result.getResponse().getContentAsString(),objectMapper.writeValueAsString(responseDto));
    }
}
