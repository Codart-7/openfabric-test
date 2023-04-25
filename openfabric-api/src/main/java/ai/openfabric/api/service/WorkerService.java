package ai.openfabric.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.repository.WorkerRepository;
import lombok.NonNull;

@Service
public class WorkerService {

    private DockerClient workerClient;
    
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> listWorkers(int page, int size) {
        List<Container> workers = workerClient.listContainersCmd().exec();

        for (Container eachWorker : workers) {
            Optional<Worker> optionalWorker = workerRepository.findById(eachWorker.getId());

            if (!optionalWorker.isPresent()) {
                Worker worker = new Worker();
                workerRepository.save(worker);
            }
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        return workerRepository.findAll(pageRequest).getContent();
    }

    public void start(@NonNull String containerID) {
        workerClient.startContainerCmd(containerID).exec();
    }
    
    public void stop(@NonNull String containerID) {
        workerClient.stopContainerCmd(containerID).exec();
    }

    public Boolean startWorker(String workerID){
        Worker worker = workerRepository.findById(workerID).get();
        start(worker.getContainer_id());
        return true;
    }

    public Boolean stopWorker(String workerID){
        Worker worker = workerRepository.findById(workerID).get();
        stop(worker.getContainer_id());
        return true;
    }
    
}
