package org.foundations.map;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapSchedulerExample {
    private static final DateTimeFormatter F = DateTimeFormatter.ISO_LOCAL_TIME.withZone(ZoneId.systemDefault());

    public static void main(String[] args) throws Exception {
        TreeMap<Instant, String> schedule = new TreeMap<>();

        // populate with sample events
        Instant now = Instant.now();
        schedule.put(now.plusSeconds(30), "Short task");
        schedule.put(now.plusSeconds(90), "Send report");
        schedule.put(now.plusSeconds(3600), "Hourly job");
        schedule.put(now.plusSeconds(7200), "Two-hour maintenance");

        // 1) Find the next event at or after 'now'
        Map.Entry<Instant, String> next = schedule.ceilingEntry(now);
        if (next != null) {
            System.out.println("Next event: " + F.format(next.getKey()) + " -> " + next.getValue());
        }

        // 2) Get all events in the next 1 hour (range query)
        Instant end = now.plus(Duration.ofHours(1));
        NavigableMap<Instant, String> upcoming = schedule.subMap(now, true, end, true);
        System.out.println("\nEvents in the next hour:");
        upcoming.forEach((t, ev) -> System.out.println("  " + F.format(t) + " -> " + ev));

        // 3) Evict past events (pollFirstEntry)
        System.out.println("\nEvicting past events (simulate advancing time)...");
        Instant simulateNow = now.plusSeconds(1000); // move time forward
        while (!schedule.isEmpty()) {
            Map.Entry<Instant, String> first = schedule.firstEntry();
            if (first.getKey().isBefore(simulateNow)) {
                Map.Entry<Instant, String> removed = schedule.pollFirstEntry();
                System.out.println("  Evicted: " + F.format(removed.getKey()) + " -> " + removed.getValue());
            } else break;
        }
    }

}
