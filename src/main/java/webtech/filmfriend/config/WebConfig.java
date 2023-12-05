package webtech.filmfriend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*/api/**")
                .allowedOrigins(
                        "http://localhost:3000",
                        "http://filmfriend-frontend.onrender.com"
                )
                .allowedHeaders("*");
    }
}
