package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class RollController {

    @Autowired
    RollService service;

    @CrossOrigin
    @PostMapping("/api/roll")
    public Roll createRoll(@RequestParam Long stockId, @RequestParam Long cameraId) {
        return service.assignRollToCamera(cameraId, stockId);
    }

    @CrossOrigin
    @DeleteMapping("/api/roll/{id}")
    public Cameramodel deleteRoll(@PathVariable String id) {
        Long cameraId = Long.parseLong(id);
        return service.deleteRollFromCamera(cameraId);
    }

}
