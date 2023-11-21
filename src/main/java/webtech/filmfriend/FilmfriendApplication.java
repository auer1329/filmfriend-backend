package webtech.filmfriend;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmfriendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmfriendApplication.class, args);
		try{
			FilmindexUpdateService.updateFilmindex();
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
