package webtech.filmfriend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository repo;
    static final String url = "https://filmapi.vercel.app/api/films";


    public Stock save(Stock stock) {
        return repo.save(stock);
    }

    public Stock get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    //@EventListener(ApplicationReadyEvent.class)
    public void updateFilmindex() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode stocksNode = mapper.readTree(jsonString);
        List<Stock> stocks = new ArrayList<>();

        for (JsonNode stockNode : stocksNode) {
            stocks.add(new Stock(
                    (long) (stockNode.get("_id").asText().hashCode()),
                    stockNode.get("brand").asText(),
                    stockNode.get("name").asText(),
                    stockNode.get("iso").asInt(),
                    stockNode.get("formatThirtyFive").asBoolean(),
                    stockNode.get("formatOneTwenty").asBoolean(),
                    stockNode.get("color").asBoolean(),
                    stockNode.get("process").asText(),
                    stockNode.get("staticImageUrl").asText(),
                    stockNode.get("description").asText(),
                    null //stockNode.get("keyFeatures").asText() // TODO parse keyFeatures
            ));
        }
        repo.saveAll(stocks);
    }

    public Iterable<Stock> getAll() {
        return repo.findAll();
    }
}