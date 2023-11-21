package webtech.filmfriend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FilmindexUpdateService{

    FilmindexUpdateService filmindexUpdateService;
    static final String url = "https://filmapi.vercel.app/api/films";

    public static void updateFilmindex() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode stocksNode = mapper.readTree(jsonString);
        List <Stock> stocks = new ArrayList<>();

        for (JsonNode stockNode : stocksNode) {
            stocks.add(new Stock(
                    stockNode.get("_id").asText(),
                    stockNode.get("brand").asText(),
                    stockNode.get("name").asText(),
                    stockNode.get("iso").asInt(),
                    stockNode.get("formatThirtyFive").asBoolean(),
                    stockNode.get("formatOneTwenty").asBoolean(),
                    stockNode.get("color").asBoolean(),
                    stockNode.get("process").asText(),
                    stockNode.get("staticImageUrl").asText(),
                    stockNode.get("description").asText(),
                    null //stockNode.get("keyFeatures").asText()
                    ));
        }
    }
}
