package cn.fcsca.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * ScheduledService
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 20:20 2018-08-25
 */
@Service
public class ScheduledService {

    /**
     * @Scheduled(cron = "0 * * * * MON-SAT")
     * @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
     * @Scheduled(cron = "0-4 * * * * MON-SAT")
     *
     * @param
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 20:28 2018-08-25
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello...");
    }
}
