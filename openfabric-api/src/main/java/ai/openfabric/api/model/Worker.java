package ai.openfabric.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Entity()
public class Worker extends Datable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "of-uuid")
    @GenericGenerator(name = "of-uuid", strategy = "ai.openfabric.api.model.IDGenerator")
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String image;

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private String ipAddress;

    @Getter
    @Setter
    private int port;

    
    @Getter
    @Setter
    private String containerId;

    @Getter
    @Setter
    private String hostName;

    @Getter
    @Setter
    private String networkName;

}
