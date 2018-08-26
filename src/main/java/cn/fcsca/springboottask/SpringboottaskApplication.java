package cn.fcsca.springboottask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringboottaskApplication
 * @EnableAsync 开启基于注解的异步任务
 * @EnableScheduling 开启基于注解的定时任务
 *
 * @author Fcscanf@樊乘乘
 * @date 下午 20:23 2018-08-25
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringboottaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboottaskApplication.class, args);
    }
}
