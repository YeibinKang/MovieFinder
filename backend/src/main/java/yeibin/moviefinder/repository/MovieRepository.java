package yeibin.moviefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yeibin.moviefinder.model.entity.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //find movie with tmdb Id
    Optional<Movie> findByTmdbId(Long tmdbId);
    //find movies containing movie title
    List<Movie> findByTitle(String title);
}