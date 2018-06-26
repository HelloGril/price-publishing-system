package com.hywa.pricepublish.event.eventhandler;

import com.hywa.pricepublish.event.PriceCollectHistoryCreateEvent;
import com.hywa.pricepublish.service.collect.CollectionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PriceCollectEventHandler {
    @Autowired
    private CollectionHistoryService collectionHistoryService;

    @EventListener
    public void saveCollectionHistory(PriceCollectHistoryCreateEvent event) {
        Map source = (Map) event.getSource();

        collectionHistoryService.save(
                (String) source.get("marketName"),
                (String) source.get("historyId"),
                (String) source.get("dateTime"),
                (String) source.get("userId"));
    }
}
