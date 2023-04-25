package ai.openfabric.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkerPort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String ip;

    @Getter
    @Setter
    private Integer private_port;

    @Getter
    @Setter
    private Integer public_port;

    @Getter
    @Setter
    private String type;

}
