package com.example.DbtoFile.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Covid {
    private Long id;
    private String agebracket;
    private String contractedfromwhichpatientsuspected;
    private String currentstatus;
    private String dateannounced;
    private String detectedcity;
    private String detecteddistrict;
    private String detectedstate;
    private String entryid;
    private String gender;
    private String nationality;
    private String notes;
    private String numcases;
    private String patientnumber;
    private String source1;
    private String source2;
    private String source3;
    private String statecode;
    private String statepatientnumber;
    private String statuschangedate;
    private String typeoftransmission;
}
