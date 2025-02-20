package yeibin.moviefinder.model.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMDBMovieListDTO {

    @JsonProperty("results")
    private List<TMDBMovieDTO> results;
    private int page;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_results")
    private int totalResults;

    @Override
    public String toString() {
        return "TMDBMovieListDTO{" +
                "results=" + results +
                ", page=" + page +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
