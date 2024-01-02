package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
public class RollController {

    @Autowired
    RollService service;

    @CrossOrigin
    @GetMapping("/api/roll/")
    public Iterable<Roll> getAllRolls() {
        return service.getAllRolls();
    }

    @CrossOrigin
    @PostMapping("/api/roll")
    public Roll createRoll(@RequestParam Long stockId, @RequestParam Long cameraId) {
        return service.assignRollToCamera(cameraId, stockId);
    }

    @CrossOrigin
    @DeleteMapping("/api/roll/{id}")
    public Cameramodel deleteRoll(@PathVariable Long id) {
        return service.deleteRollFromCamera(id);
    }

    @CrossOrigin
    @PutMapping("/api/roll")
    public Roll developRoll(@RequestParam Long cameraId, @RequestParam LocalDate expectedPickupDate, @RequestParam int usedIso,  @RequestParam String labName, @RequestParam String notes) {
        return service.developRoll(cameraId, expectedPickupDate, usedIso, labName, notes);
    }
}
