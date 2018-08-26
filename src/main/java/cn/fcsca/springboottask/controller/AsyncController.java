package cn.fcsca.springboottask.controller;

import cn.fcsca.springboottask.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AsyncController
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 20:06 2018-08-25
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }
}
