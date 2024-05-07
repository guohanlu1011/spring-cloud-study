package com.han.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.han.entities.Pay;
import com.han.entities.PayDto;
import com.han.service.PayService;
import com.han.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Tag(name = "支付微服务模块", description = "订单CRUD")
@Slf4j
@RestController
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @Value("${server.port}")
    private Integer port;
//    @Value("${han.info}")
//    private String info;

    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水, 参数是JSON字符串")
    public Result<Integer> addPay(@RequestBody PayDto PayDto) {
        log.info("新增调用开始 --- {}", DateUtil.now());
        try {
            Pay pay = new Pay();
            BeanUtils.copyProperties(PayDto, pay);
            Thread.sleep(200000);
            int add = payService.add(pay);
            log.info("新增调用完成 --- {}", DateUtil.now());
            return Result.success(add);
        } catch (Exception e) {
            log.info("新增调用失败 --- {}", DateUtil.now());
            return Result.fail(e.getMessage());
        }
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水, 参数是Id")
    public Result<Integer> deletePay(@PathVariable("id") Integer id) {
        try {
            log.info("查询调用开始 --- {}", DateUtil.now());
            Thread.sleep(200000);
            return Result.success(payService.delete(id));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PutMapping("/update")
    @Operation(summary = "更新", description = "更新支付流水, 参数是JSON字符串, 根据Id更新")
    public Result<Integer> updatePay(@RequestBody PayDto PayDto) {
        try {
            Pay pay = new Pay();
            BeanUtils.copyProperties(PayDto, pay);
            return Result.success(payService.update(pay));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "查询单个", description = "查询支付流水, 参数是Id")
    public Result<PayDto> getById(@PathVariable("id") Integer id) {
        PayDto PayDto = new PayDto();
        log.info("查询调用开始 --- {}", DateUtil.now());
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(payService.getById(id), PayDto);
        return Result.success(PayDto);
    }

    @GetMapping("/getAll")
    @Operation(summary = "查询所有", description = "查询所有支付流水")
    public Result<List<PayDto>> getAll() {
        try {
            List<Pay> pays = payService.getAll();
            List<PayDto> PayDtos = Convert.toList(PayDto.class,pays);
            return Result.success(PayDtos);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getInfo")
    public Result<String> getInfo(@Value("${wong.info}") String info) {
        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Result.success("port: " + port + "\t Info: " + info);
    }

//    @GetMapping("/getHello")
//    public Result<String> getHello() {
//        return Result.success(info);
//    }

}
