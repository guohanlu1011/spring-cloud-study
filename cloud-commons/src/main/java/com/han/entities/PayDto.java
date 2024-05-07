package com.han.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @className: PayDto
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/23
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDto {

    private Integer id;

    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 订单流水号
     */
    private String orderNo;



    private Integer userId;

    /**
     * 交易金额
     */
    private BigDecimal amount;

}
