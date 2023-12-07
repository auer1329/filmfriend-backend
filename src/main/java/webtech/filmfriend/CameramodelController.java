package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameramodelController {

    @Autowired
    CameramodelService service;
    @CrossOrigin
    @PostMapping("/api/cameramodel")
    public Cameramodel createCameramodel(@RequestBody Cameramodel cameramodel) {
        return service.save(cameramodel);
    }

    @CrossOrigin
    @GetMapping("/api/cameramodel/{id}")
    public Cameramodel getCameramodel(@PathVariable String id) {
        Long cameramodelId = Long.parseLong(id);
        return service.get(cameramodelId);
    }

    @CrossOrigin
    @GetMapping("/api/cameramodel")
    public Iterable<Cameramodel> getAllCameramodels() {
        return service.getAll();
    }
}
