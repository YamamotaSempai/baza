package kz.aa.baza.configs;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kz.as.registry.CityServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpsConfig {
    @Bean
    public ManagedChannel channel() {
        return ManagedChannelBuilder.forAddress("localhost", 7777)
                .usePlaintext()
                .build();
    }

    @Bean
    public CityServiceGrpc.CityServiceBlockingStub cityServiceStub(ManagedChannel channel) {
        return CityServiceGrpc.newBlockingStub(channel);
    }
}
