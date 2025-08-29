package com.tech3.erp.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RollNumberGenerator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");
    private final AtomicInteger sequence = new AtomicInteger(1);

    public String generateRollNumber() {
        String datePart = LocalDate.now().format(DATE_FORMATTER);
        int seq = sequence.getAndIncrement();
        return "RN" + datePart + String.format("%04d", seq);
    }
}