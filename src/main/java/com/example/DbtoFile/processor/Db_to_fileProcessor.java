package com.example.DbtoFile.processor;

import com.example.DbtoFile.model.Covid;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Db_to_fileProcessor implements ItemProcessor<Covid, Covid> {

    @Override
    public Covid process(Covid covid) throws Exception {
        if(covid.getId()==null)
            covid.setId(-1L);
        if(covid.getAgebracket().equals(""))
            covid.setAgebracket("NA");
        if(covid.getContractedfromwhichpatientsuspected().equals(""))
            covid.setContractedfromwhichpatientsuspected("NA");
        if(covid.getCurrentstatus().equals(""))
            covid.setCurrentstatus("NA");
        if(covid.getDateannounced().equals(""))
            covid.setDateannounced("NA");
        if(covid.getDetectedcity().equals(""))
            covid.setDetectedcity("NA");
        if(covid.getDetectedstate().equals(""))
            covid.setDetectedstate("NA");
        if(covid.getDetecteddistrict().equals(""))
            covid.setDetecteddistrict("NA");
        if(covid.getEntryid().equals(""))
            covid.setEntryid("NA");
        if(covid.getGender().equals("NA"))
            covid.setGender("NA");
        if(covid.getNationality().equals(""))
            covid.setNationality("NA");
        if(covid.getNotes().equals(""))
            covid.setNotes("NA");
        if(covid.getNumcases().equals(""))
            covid.setNumcases("NA");
        if(covid.getPatientnumber().equals(""))
            covid.setPatientnumber("NA");
        if(covid.getSource1().equals(""))
            covid.setSource1("NA");
        if(covid.getSource2().equals(""))
            covid.setSource2("NA");
        if(covid.getSource3().equals(""))
            covid.setSource3("NA");
        if(covid.getCurrentstatus().equals(""))
            covid.setCurrentstatus("NA");
        if(covid.getStatuschangedate().equals(""))
            covid.setStatuschangedate("NA");
        if(covid.getStatepatientnumber().equals(""))
            covid.setStatepatientnumber("NA");
        if(covid.getTypeoftransmission().equals(""))
            covid.setTypeoftransmission("NA");

        return covid;
    }
}
