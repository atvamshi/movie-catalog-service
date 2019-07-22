package io.uv.moviecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: movie-info-service
 * Package: io.uv.movieinfoservice.models
 * <p>
 * User: vamshi
 * Date: 2019-07-21
 * Time: 10:17
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private String movieId;
    private String name;
}
