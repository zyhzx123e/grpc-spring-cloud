package com.grpc.spring.client.service;

import com.grpc.spring.api.order.GetOrderReply;
import com.grpc.spring.api.order.GetOrderRequest;
import com.grpc.spring.api.order.OrderServiceGrpc;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 *  order info get client port
 */
@Service
@Log4j2
public class GrpcOrderClientService {

    @GrpcClient("grpc-server")
    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    /**
     * get order info
     * @param orderNo
     * @return
     */
    public String getOrderInfo(String orderNo) {
        try {
            //return back the rpc remote port to client
            GetOrderRequest request  = GetOrderRequest.newBuilder().setOrderNo(orderNo).build();
            final GetOrderReply response = orderServiceBlockingStub.getOrderInfo(request);
            String result = "orderNo: " + response.getOrderNo() + ", userName: " + response.getUserName() + ", address: " + response.getAddress();
            return result;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error! " + e.getMessage();
        }
    }

}
