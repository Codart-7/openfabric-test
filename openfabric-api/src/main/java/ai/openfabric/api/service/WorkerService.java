package ai.openfabric.api.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.repository.WorkerRepository;

@Service
public class WorkerService {
    
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> listWorkers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return workerRepository.findAll(pageRequest).getContent();
    }
    
}
