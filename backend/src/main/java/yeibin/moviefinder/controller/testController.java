package yeibin.moviefinder.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yeibin.moviefinder.repository.MovieRepository;

@RestController

public class TestController {
    private final MovieRepository movieRepository;
    public TestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/test")
    public String testConnection(){
        try{
            long count = movieRepository.count();
            return "Database connected successfully! Movie count: " + count;
        } catch (java.lang.Exception e) {
            return "Connection failed: " + e.getMessage();
        }
    }
}