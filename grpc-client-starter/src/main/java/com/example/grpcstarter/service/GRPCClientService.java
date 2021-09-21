package com.example.grpcstarter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;

import com.example.grpcstarter.lib.PingPongServiceGrpc;
import com.example.grpcstarter.lib.PingRequest;
import com.example.grpcstarter.lib.PongResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GRPCClientService {

    @GrpcClient("local-grpc-server")
    private PingPongServiceGrpc.PingPongServiceBlockingStub stub;

    public String sendMessage(String name) {
        PongResponse response = stub.ping(PingRequest.newBuilder().setPing(name).build());
        return response.getPong();
    }
}
