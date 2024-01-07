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
class StockServiceTest {
    @Autowired
    StockService service;

    @MockBean
    StockRepository repo;
    @Test
    @DisplayName("Should find stock by id")
    void get() {
        var stock1 = new Stock(10L, "Kodak", "Portra 400", 400, false, true, true,
                "C-41", "https://filmapi.vercel.app/api/films/1/static.jpg",
                "The most popular film in the world", null);
        var stock2 = new Stock(20L, "Kodak", "Portra 800", 800, false, true, true,
                "C-41", "https://filmapi.vercel.app/api/films/2/static.jpg",
                "The second most popular film in the world", null);
        doReturn(Optional.of(stock1)).when(repo).findById(10L);
        doReturn(Optional.of(stock2)).when(repo).findById(20L);

        Stock actual = service.get(10L);
        assertEquals(actual.getIso(), 400);
    }
}