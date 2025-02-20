package yeibin.moviefinder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import yeibin.moviefinder.client.TMDBClient;
import yeibin.moviefinder.model.dto.tmdb.TMDBMovieDTO;
import yeibin.moviefinder.model.dto.tmdb.TMDBMovieListDTO;


import java.util.List;

@Service
public class MovieService {

    private final TMDBClient tmdbClient;

    @Autowired
    public MovieService(TMDBClient tmdbClient){
        this.tmdbClient = tmdbClient;
    }

    //get Now playign Movie list
    public TMDBMovieListDTO getNowPlayingMovies(){
        return tmdbClient.getNowPlayingMovies();
    }

    public TMDBMovieDTO getMovieById(Long tmdbId){
        return tmdbClient.getMovieById(tmdbId);
    }

    public TMDBMovieListDTO searchMoviesByTitle(String title){
        return tmdbClient.searchMoviesByTitle(title);
    }

}
