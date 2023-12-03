package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameramodelController {

    @Autowired
    CameramodelService cameramodelService;

    @PostMapping("/api/cameramodel")
    public Cameramodel saveCameramodel(@RequestBody Cameramodel cameramodel) {
        return cameramodelService.save(cameramodel);
    }

    @GetMapping("/api/cameramodel")
    public Iterable<Cameramodel> getAllCameramodels() {
        return cameramodelService.getAll();
    }

    @GetMapping("/api/cameramodel/{id}")
    public Cameramodel getCameramodel(@PathVariable String id) {
        Long cameramodelId = Long.parseLong(id);
        return cameramodelService.get(cameramodelId);
    }
}
