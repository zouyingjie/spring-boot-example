package com.springboot.example.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class ScheduleTask {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm:ss"
    );

    // 固定频率，每 3s 执行一次
    @Scheduled(fixedRate = 3000)
    private void schedule01() {
        log.info("schedule01 -> {}", LocalDateTime.now().format(fmt));
    }

    // 固定延时，上一次任务执行完毕 3s 之后在执行。
    @Scheduled(fixedDelay = 3000)
    private void schedule02() {
        log.info("schedule02 -> {}", LocalDateTime.now().format(fmt));
    }

    // 第一次延迟 2s 执行，之后每 3s 执行
    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    private void schedule03() {
        log.info("schedule03 -> {}", LocalDateTime.now().format(fmt));
    }

    // 按照 Linux 的 cron 格式
    @Scheduled(cron = "*/3 * * * * ?")
    private void schedule04() {
        log.info("schedule04 -> {}", LocalDateTime.now().format(fmt));
    }
}
