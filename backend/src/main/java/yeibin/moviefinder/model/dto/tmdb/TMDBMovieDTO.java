package yeibin.moviefinder.model.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMDBMovieDTO {
    private Long id;
    private String title;
    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private Double popularity;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("adult")
    private boolean adult;

    // 영화 상세 정보에는 genre_ids 대신 genres 객체 배열이 옴
    private List<Genre> genres;

    @JsonProperty("original_language")
    private String originalLanguage;
    private boolean video;
    @JsonProperty("vote_count")
    private int voteCount;

    // 추가된 필드들
    @JsonProperty("imdb_id")
    private String imdbId;
    private String status;
    private Integer runtime;
    private String tagline;
    @JsonProperty("belongs_to_collection")
    private Collection belongsToCollection;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Genre {
        private Long id;
        private String name;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Collection {
        private Long id;
        private String name;
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("backdrop_path")
        private String backdropPath;
    }

    @Override
    public String toString() {
        return "TMDBMovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", voteAverage=" + voteAverage +
                ", popularity=" + popularity +
                ", imdbId='" + imdbId + '\'' +
                ", runtime=" + runtime +
                ", status='" + status + '\'' +
                '}';
    }
}