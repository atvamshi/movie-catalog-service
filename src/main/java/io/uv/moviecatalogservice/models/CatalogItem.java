package io.uv.moviecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: movie-catalog-service
 * Package: io.uv.moviecatalogservice.models
 * <p>
 * User: vamshi
 * Date: 2019-07-21
 * Time: 10:05
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {
    private String name;
    private String desc;
    private int rating;
}
