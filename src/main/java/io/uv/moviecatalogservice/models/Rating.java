package io.uv.moviecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: rating-data-service
 * Package: io.uv.ratingdataservice.models
 * <p>
 * User: vamshi
 * Date: 2019-07-21
 * Time: 10:28
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {
    private String movieId;
    private int rating;
}
