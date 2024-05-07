package com.han.apis;

import com.han.entities.PayDto;
import com.han.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @className: PayFeignApi
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/25
 **/

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    @PostMapping("/pay/add")
    Result<Integer> addPay(@RequestBody PayDto PayDto);

    @GetMapping("/pay/get/{id}")
    Result<PayDto> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/circuit/{id}")
    Result<String> myCircuit(@PathVariable("id") Integer id);
}
