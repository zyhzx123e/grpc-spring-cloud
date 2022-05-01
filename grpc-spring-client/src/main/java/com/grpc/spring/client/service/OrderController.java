package com.grpc.spring.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * order service controller
 * @author hekun
 * @date 2021/9/6
 */
@RestController
public class OrderController {

    @Autowired
    private GrpcOrderClientService grpcOrderClientService;

    /**
     * get order info
     * @param orderNo
     * @return
     */
    @RequestMapping("/getOrder")
    public String getOrder(@RequestParam(defaultValue = "10001")String orderNo) {
        return grpcOrderClientService.getOrderInfo(orderNo);
    }
}
