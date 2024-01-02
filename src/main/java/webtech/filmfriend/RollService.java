package webtech.filmfriend;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RollService {
    @Autowired
    RollRepo rollRepo;
    @Autowired
    CameramodelRepo cameraRepository;
    @Autowired
    StockRepository stockRepo;

    @Transactional
    public Roll assignRollToCamera(Long cameraId, Long stockId) {
        Cameramodel camera = cameraRepository.findById(cameraId).orElseThrow(() -> new RuntimeException("Camera not found"));
        if (camera != null && camera.getRoll() == null) {
            Roll newRoll = createNewRoll(stockId);
            camera.setRoll(newRoll);
            cameraRepository.save(camera);
            return newRoll;
        }
        throw new RuntimeException("Camera already has a roll");
    }

    public Roll getRoll(Long rollId) {
        return rollRepo.findById(rollId).orElseThrow(() -> new RuntimeException("Roll not found"));
    }

    public Iterable <Roll> getAllRolls() {
        return rollRepo.findAll();
    }

    private Roll createNewRoll(Long stockId) {
        Roll roll = new Roll();
        Stock stock = stockRepo.findById(stockId).orElseThrow(() -> new RuntimeException("Stock not found"));
        roll.setStock(stock);
        rollRepo.save(roll);
        return roll;
    }

    public Roll developRoll(Long cameraId, LocalDate expectedPickupDate, int usedIso, String labName, String notes) {
        Cameramodel camera = cameraRepository.findById(cameraId).orElseThrow(() -> new RuntimeException("Camera not found"));
        Roll roll = camera.getRoll();
        if (roll == null) {
            throw new RuntimeException("Camera has no roll");
        }
        roll.setExpectedPickupDate(expectedPickupDate);
        roll.setUsedIso(usedIso);
        roll.setLabName(labName);
        roll.setNotes(notes);
        rollRepo.save(roll);
        camera.setRoll(null);
        cameraRepository.save(camera);
        return roll;
    }

    public Cameramodel deleteRollFromCamera(Long cameraId) {
        Cameramodel camera = cameraRepository.findById(cameraId).orElseThrow(() -> new RuntimeException("Camera not found"));
        Long id = camera.getRoll().getId();
        camera.setRoll(null);
        rollRepo.deleteById(id);
        cameraRepository.save(camera);
        return camera;
    }
}
