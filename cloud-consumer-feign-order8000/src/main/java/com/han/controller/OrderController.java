package com.han.controller;

import cn.hutool.core.date.DateUtil;
import com.han.apis.PayFeignApi;
import com.han.entities.PayDto;
import com.han.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/pay/add")
    public Result<Integer> addOrder(@RequestBody PayDto payDTO) {

        log.info("调用开始 -- {}", DateUtil.now());
        Result<Integer> result = null;
        try {
            result = payFeignApi.addPay(payDTO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("feign调用超时 --- {}", DateUtil.now());
        }

        log.info("调用结束 --- {}", DateUtil.now());
        return result;
    }


    @GetMapping("/pay/get/{id}")
    public Result<PayDto> getPayInfo(@PathVariable("id") Integer id) {
        log.info("调用开始 -- {}", DateUtil.now());
        Result<PayDto> byId = null;
        try {
             byId = payFeignApi.getById(id);
        } catch (Exception e) {
            log.info("feign调用超时 --- {}", DateUtil.now());
        }
        log.info("调用结束 --- {}", DateUtil.now());
        return byId;
    }


}
