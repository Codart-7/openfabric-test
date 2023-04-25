package ai.openfabric.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.service.WorkerService;

@RestController
@RequestMapping("${node.api.path}/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(path = "/hello")
    public ResponseEntity<String> hello(@RequestBody String name) {
        return new ResponseEntity<String>("Hello " + name, HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public @ResponseBody List<Worker> listWorkers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return workerService.listWorkers(page, size);
    }

    @PostMapping(path="/stop")
    public @ResponseBody Boolean stopWorker(@RequestBody String id){
        return workerService.stopWorker(id);
    }

    @PostMapping(path="/start")
    public @ResponseBody Boolean startWorker(@RequestBody String id){
        return workerService.startWorker(id);
    }

}
