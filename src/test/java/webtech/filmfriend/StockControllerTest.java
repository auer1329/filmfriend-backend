package webtech.filmfriend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(StockController.class)
class StockControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    StockService service;

    @Test
    @DisplayName("should get stock on id")
    void getStock() throws Exception {
        var stock1 = new Stock(10L, "Kodak", "Portra 400", 400, false, true, true,
                "C-41", "https://filmapi.vercel.app/api/films/1/static.jpg",
                "The most popular film in the world", null);
        var stock2 = new Stock(20L, "Kodak", "Portra 800", 800, false, true, true,
                "C-41", "https://filmapi.vercel.app/api/films/2/static.jpg",
                "The second most popular film in the world", null);
        var stock3 = new Stock(30L, "Kodak", "Portra 160", 160, false, true, true,
                "C-41", "https://filmapi.vercel.app/api/films/3/static.jpg",
                "The third most popular film in the world", null);

        when(service.get(10L)).thenReturn(stock1);
        when(service.get(20L)).thenReturn(stock2);
        when(service.get(30L)).thenReturn(stock3);

        String expected = "{\"id\":10,\"brand\":\"Kodak\",\"name\":\"Portra 400\",\"iso\":400,\"formatThirtyFive\":false,\"formatOneTwenty\":true,\"color\":true,\"process\":\"C-41\",\"staticImageUrl\":\"https://filmapi.vercel.app/api/films/1/static.jpg\",\"description\":\"The most popular film in the world\",\"keyFeatures\":null}";
        this.mockMvc.perform(get("/api/stocks/10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}