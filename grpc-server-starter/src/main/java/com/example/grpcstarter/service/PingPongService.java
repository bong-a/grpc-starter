package com.example.grpcstarter.service;

import net.devh.boot.grpc.server.service.GrpcService;

import com.example.grpcstarter.lib.PingPongServiceGrpc;
import com.example.grpcstarter.lib.PingRequest;
import com.example.grpcstarter.lib.PongResponse;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@GrpcService
public class PingPongService extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void ping(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        log.info("ping : {}", request.getPing());
        String ping = request.getPing() + " pong";
        PongResponse response = PongResponse.newBuilder()
            .setPong(ping)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
