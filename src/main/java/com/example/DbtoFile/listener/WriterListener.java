package com.example.DbtoFile.listener;

import com.example.DbtoFile.model.Covid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WriterListener implements ItemWriteListener<Covid> {
    @Override
    public void beforeWrite(List<? extends Covid> list) {
        //log.info("Writer listener beforeWrite() method called...");

    }

    @Override
    public void afterWrite(List<? extends Covid> list) {
       // log.info("Writer listener afterWrite() method called...");
    }

    @Override
    public void onWriteError(Exception e, List<? extends Covid> list) {
        log.info("Writer listener onWriteError() method called...");
    }
}
