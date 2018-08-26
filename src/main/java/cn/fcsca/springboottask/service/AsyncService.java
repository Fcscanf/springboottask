package cn.fcsca.springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * AsyncService
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 20:03 2018-08-25
 */
@Service
public class AsyncService {

    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中。。。");
    }
}
