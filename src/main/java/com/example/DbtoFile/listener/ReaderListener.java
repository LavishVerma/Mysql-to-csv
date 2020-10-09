package com.example.DbtoFile.listener;

import com.example.DbtoFile.model.Covid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class ReaderListener implements ItemReadListener<Covid> {
    @Override
    public void beforeRead() {
    //log.info("Reader Listener beforeRead() method called...");
    }

    @Override
    public void afterRead(Covid covid) {
        //log.info("Reader Listener afterRead() method called...");
    }

    @Override
    public void onReadError(Exception e) {
        log.info("Reader Listener onReadError() method called...");

    }
}
