package com.han.service;


import java.util.List;
import com.han.entities.Pay;

/**
 * @className: PayService
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/23
 **/

public interface PayService {

    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
