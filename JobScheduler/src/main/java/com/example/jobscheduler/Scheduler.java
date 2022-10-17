package com.example.jobscheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
//@EnableAsync
public class Scheduler {

    /**
        fixedDelay : Thuộc tính fixedDelay đảm bảo rằng có độ trễ n mili giây giữa thời gian kết thúc thực hiện một tác vụ
        và thời gian bắt đầu thực hiện tác vụ tiếp theo
        fixedDelay : Là thời gian còn lại khi công việc được hoàn thành. Sau thời gian còn lại, nó sẽ thực hiện nhiệm vụ tiếp theo.

        fixedRate : Thuộc tính fixedRate chạy tác vụ đã lên lịch sau mỗi n mili giây. Nó không kiểm trả bất kỳ lần thực thi trước đó của tác vụ
        fixedRate : Là khoảng thời gian giữa thời gian bắt đầu để thực hiện nhiệm vụ trước và thời gian bắt đầu để thực hiện nhiệm vụ tiếp theo,
        nó không phụ thuộc vào việc công việc trước đó đã hoàn thành hay không.
     */


    /**
        initialDelay : Độ trễ ban đầu
        Async : Không đồng bộ

    */
//    @Async
//    @Scheduled(fixedRateString = "PT02S", initialDelay = 1000)
    @Scheduled(cron = "${cron.expression.value}")
    public void scheduler() throws InterruptedException {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = current.format(formatter);
        log.info("Scheduler time "+formattedDateTime);
        Thread.sleep(1000);
    }
}
