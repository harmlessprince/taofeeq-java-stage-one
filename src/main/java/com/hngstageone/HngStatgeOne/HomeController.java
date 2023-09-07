package com.hngstageone.HngStatgeOne;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

@RestController
public class HomeController {

    @GetMapping()
    public Object index(@RequestParam Optional<String> slack_name, @RequestParam Optional<String> track) {

        slack_name = slack_name.isPresent() ? slack_name : Optional.of("HNGx");
        track = track.isPresent() ? track : Optional.of("Backend");
        // Get the current UTC time
        Instant currentInstant = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

        // Format the current UTC time as "2023-08-21T15:04:05Z"
        String formattedUTC = formatter.format(currentInstant.atZone(ZoneOffset.UTC));

        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime zonedDateTime = currentInstant.atZone(zoneId);

        // Get the day of the week from the ZonedDateTime
        DayOfWeek dayOfWeek = zonedDateTime.getDayOfWeek();
        String currentDay = StringUtils.capitalize(dayOfWeek.toString().toLowerCase());
        HashMap<String, Object> data = new HashMap<>();
        data.put("slack_name", slack_name);
        data.put("current_day", currentDay);
        data.put("utc_time", (formattedUTC).toUpperCase());
        data.put("track", track);
        data.put("github_file_url", "https://github.com/harmlessprince/taofeeq-java-stage-one/blob/main/src/main/java/com/hngstageone/HngStatgeOne/HomeController.java");
        data.put("github_repo_url", "https://github.com/harmlessprince/taofeeq-java-stage-one");
        data.put("status_code", 200);

        return data;
    }
}
