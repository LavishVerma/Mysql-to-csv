package com.example.DbtoFile.listener;

import com.example.DbtoFile.model.Covid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class ProcessorListener implements ItemProcessListener<Covid,Covid> {
    @Override
    public void beforeProcess(Covid covid) {
     //log.info("Processor Listener beforeProcess() method called...");
    }

    @Override
    public void afterProcess(Covid covid, Covid covid2) {
       // log.info("Processor Listener AfterProcess() method called...");
    }

    @Override
    public void onProcessError(Covid covid, Exception e) {
        log.info("Processor Listener onProcessError() method called...");
    }
}
