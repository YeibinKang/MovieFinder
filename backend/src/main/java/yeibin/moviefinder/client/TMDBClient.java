package yeibin.moviefinder.client;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import yeibin.moviefinder.model.dto.tmdb.TMDBMovieDTO;
import yeibin.moviefinder.model.dto.tmdb.TMDBMovieListDTO;


@Component
public class TMDBClient {

    private final WebClient webClient;


    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.base-url}")
    private String baseUrl;

    private Integer page;

    public TMDBClient(WebClient webClient){
        this.webClient = webClient;
    }


    //Get Now playing movies
    //Return a list of now playing movies
    public TMDBMovieListDTO getNowPlayingMovies() {
        try {
            String rawResponse = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/movie/now_playing")
                            .queryParam("api_key", apiKey)
                            .build())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            System.out.println("Raw Response: " + rawResponse);

            ObjectMapper mapper = new ObjectMapper();
            TMDBMovieListDTO response = mapper.readValue(rawResponse, TMDBMovieListDTO.class);
            System.out.println("Manually Mapped Response: " + response);

            return response;

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Search a movie by TMDB id
    // Return a movie with details
    public TMDBMovieDTO getMovieById(Long tmdbId){
        try{
            System.out.println("Attempting to request movie with ID: " + tmdbId);
            System.out.println("Base URL + Path: /movie/" + tmdbId);

            String rawResponse = webClient.get()
                    .uri(uriBuilder -> {
                        // URI 빌드 과정 로깅
                        String fullUrl = uriBuilder
                                .path("/movie/{tmdbId}")
                                .queryParam("api_key", apiKey)
                                .build(tmdbId)
                                .toString();
                        System.out.println("Full Request URL: " + fullUrl);

                        return uriBuilder
                                .queryParam("api_key", apiKey)
                                .build(tmdbId);
                    })
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            System.out.println("Raw Response: " + rawResponse);

            ObjectMapper mapper = new ObjectMapper();
            TMDBMovieDTO response = mapper.readValue(rawResponse, TMDBMovieDTO.class);
            System.out.println("Manually Mapped Response: " + response);
            return response;

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Search a movie list with a string
    // Return a list of movies which matched with the string
    public TMDBMovieListDTO searchMoviesByTitle(String title){
        try{

            TMDBMovieListDTO response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/search/movie")
                            .queryParam("query", title)
                            .queryParam("api_key", apiKey)
                            .build()
                    )
                    .retrieve()
                    .bodyToMono(TMDBMovieListDTO.class)
                    .block();

            return response;



        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
