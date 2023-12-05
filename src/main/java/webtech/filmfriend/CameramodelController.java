package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameramodelController {

    @Autowired
    CameramodelService cameramodelService;
    @CrossOrigin
    @PostMapping("/api/cameramodel")
    public Cameramodel saveCameramodel(@RequestBody Cameramodel cameramodel) {
        return cameramodelService.save(cameramodel);
    }
    @CrossOrigin

    @GetMapping("/api/cameramodel")
    public Iterable<Cameramodel> getAllCameramodels() {
        return cameramodelService.getAll();
    }
    @CrossOrigin

    @GetMapping("/api/cameramodel/{id}")
    public Cameramodel getCameramodel(@PathVariable String id) {
        Long cameramodelId = Long.parseLong(id);
        return cameramodelService.get(cameramodelId);
    }
}
