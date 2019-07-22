package io.uv.moviecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project: rating-data-service
 * Package: io.uv.ratingdataservice.models
 * <p>
 * User: vamshi
 * Date: 2019-07-21
 * Time: 20:36
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UserRating {
    private List<Rating> userRating;
}
