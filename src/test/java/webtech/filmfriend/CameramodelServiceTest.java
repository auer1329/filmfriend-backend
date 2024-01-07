package webtech.filmfriend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class CameramodelServiceTest {

    @Autowired
    CameramodelService cameramodelService;

    @MockBean
    CameramodelRepo cameramodelRepo;

    @Test
    @DisplayName("Should find cameramodel by id")
    void get() {
        var cameramodelNikon = new Cameramodel();
        var cameramodelCanon = new Cameramodel();

        cameramodelNikon.setId(1L);
        cameramodelNikon.setBrand("Nikon");
        cameramodelNikon.setModel("F3");
        cameramodelNikon.setFormatThirtyFive(true);
        cameramodelNikon.setFormatOneTwenty(false);

        cameramodelCanon.setId(2L);
        cameramodelCanon.setBrand("Canon");
        cameramodelCanon.setModel("AE-1");
        cameramodelCanon.setFormatThirtyFive(true);
        cameramodelCanon.setFormatOneTwenty(false);

        doReturn(Optional.of(cameramodelNikon)).when(cameramodelRepo).findById(1L);
        doReturn(Optional.of(cameramodelCanon)).when(cameramodelRepo).findById(2L);

        assertEquals(cameramodelCanon.getBrand(), cameramodelService.get(2L).getBrand());
    }
}