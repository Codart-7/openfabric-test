package ai.openfabric.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${node.api.path}/worker")
public class WorkerController {


    @PostMapping(path = "/hello")
    public ResponseEntity<String> hello(@RequestBody String name) {
        return new ResponseEntity<String>("Hello! " + name, HttpStatus.OK);
    }


}
