package webtech.filmfriend;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    private Roll createNewRoll(Long stockId) {
        Roll roll = new Roll();
        Stock stock = stockRepo.findById(stockId).orElseThrow(() -> new RuntimeException("Stock not found"));
        roll.setStock(stock);
        rollRepo.save(roll);
        return roll;
    }

    public Cameramodel deleteRollFromCamera(Long cameraId) {
        Cameramodel camera = cameraRepository.findById(cameraId).orElseThrow(() -> new RuntimeException("Camera not found"));
        camera.setRoll(null);
        cameraRepository.save(camera);
        return camera;
    }
}
