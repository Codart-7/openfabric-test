package ai.openfabric.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig;


@Configuration
public class WorkerConfig {
    
    @Bean
    public DockerClient workerClient() {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
            .withDockerHost("tcp://localhost:2375") // Replace with the Docker host URL
            .withDockerTlsVerify(false) // Set to true if using TLS
            .build();
        DockerClient workerClient = DockerClientBuilder.getInstance(config).build();
        return workerClient;
    }

}
