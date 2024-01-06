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
    @DeleteMapping("/api/roll")
    public Roll deleteRoll(@RequestParam(required = false) Long cameraId, @RequestParam(required = false) Long rollId) {
        if (cameraId != null) return service.deleteRollFromCamera(cameraId);
        if (rollId != null) return service.deleteRoll(rollId);
        throw new RuntimeException("No cameraId or rollId provided");
    }

    @CrossOrigin
    @PutMapping("/api/roll")
    public Roll developRoll(@RequestParam Long cameraId, @RequestParam LocalDate expectedPickupDate, @RequestParam int usedIso,  @RequestParam String labName, @RequestParam String notes) {
        return service.developRoll(cameraId, expectedPickupDate, usedIso, labName, notes);
    }
    @CrossOrigin
    @GetMapping("/api/roll/in-development")
    public Iterable<Roll> getRollsInDevelopment() {
        return service.getRollsInDevelopment();
    }

}
