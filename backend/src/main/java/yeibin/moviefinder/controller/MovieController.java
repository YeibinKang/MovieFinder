package yeibin.moviefinder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yeibin.moviefinder.model.dto.tmdb.TMDBMovieDTO;
import yeibin.moviefinder.model.dto.tmdb.TMDBMovieListDTO;
import yeibin.moviefinder.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/now-playing")
    public TMDBMovieListDTO getNowPlayingMovies(){
        return movieService.getNowPlayingMovies();
    }

    @GetMapping("/{tmdbId}")
    public TMDBMovieDTO getMovieById(@PathVariable("tmdbId") Long tmdbId){
        return movieService.getMovieById(tmdbId);
    }


}
