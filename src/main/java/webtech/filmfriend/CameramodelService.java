package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameramodelService {
    @Autowired
    CameramodelRepo cameramodelRepo;

    public Cameramodel save(Cameramodel cameramodel) {
        return cameramodelRepo.save(cameramodel);
    }

    public Cameramodel get (Long id) {
        return cameramodelRepo.findById(id).orElseThrow(() -> new RuntimeException("Cameramodel not found"));
    }

    public Iterable<Cameramodel> getAll() {
        return cameramodelRepo.findAll();
    }

    public Cameramodel delete(Long id) {
        Cameramodel cameramodel = cameramodelRepo.findById(id).orElseThrow(() -> new RuntimeException("Cameramodel not found"));
        cameramodelRepo.delete(cameramodel);
        return cameramodel;
    }
}
