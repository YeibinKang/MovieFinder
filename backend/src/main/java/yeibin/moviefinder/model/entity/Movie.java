package yeibin.moviefinder.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="movie")
@Data
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tmdb_id", unique = true, nullable = false)
    private Long tmdbId;

    @Column(nullable = false)
    private String title;

    @Column(name="original_title")
    private String originalTitle;

    private String overView;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "vote_average")
    private BigDecimal voteAverage;

    private Integer popularity;

    private Integer runtime;

    private String status;

    @Column(name = "cached_at")
    private LocalDate cachedAt;


}