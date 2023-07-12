package com.events.application.controller;

import com.events.application.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/event/")
public class ItemEventController {

    private EventPublisher eventPublisher;

    @Autowired
    public ItemEventController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @ResponseBody
    @GetMapping("/create")
    public String createEvent() {
        eventPublisher.publishEvent("my item name");
        return "create event ok";
    }
}
