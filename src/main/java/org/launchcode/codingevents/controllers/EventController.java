package org.launchcode.codingevents.controllers;

import org.apache.coyote.Request;
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {
// we are refactoring the Event Controller to use the EventData.java class
// this starts with commenting out the line below. Then follow errors to finish editing the controller.
//    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        // Part 2 refactoring for EventData.java class is adjusting the attribute to EventData.getAll
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        //Part 3 edit of controller to use EventData.java class is to change events to EventData.add
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:";
    }

}
