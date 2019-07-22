package io.uv.moviecatalogservice.conroller;

import io.uv.moviecatalogservice.models.CatalogItem;
import io.uv.moviecatalogservice.models.Movie;
import io.uv.moviecatalogservice.models.UserRating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project: movie-catalog-service
 * Package: io.uv.moviecatalogservice.conroller
 * <p>
 * User: vamshi
 * Date: 2019-07-21
 * Time: 10:03
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(path = "/catalog")
@Slf4j
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/{userId}")
    public List<CatalogItem> getCatalogFor(@PathVariable String userId) {
//    public Mono<CatalogItem> getCatalogFor(@PathVariable String userId) {

////        get all rated movie IDs
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234", 4),
//                new Rating("5678", 3)
//        );

//        UserRating ratings = restTemplate.getForObject("http://localhost:9093/ratingData/users/" + userId, UserRating.class);
        UserRating ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingData/users/" + userId, UserRating.class);

        log.info("Instances RATING-DATA-SERVICE {}", discoveryClient.getInstances("RATING-DATA-SERVICE").size());

        ///For each movie ID, call movie info service and get details
        return ratings.getUserRating().stream().parallel().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:9092/movies/" + rating.getMovieId(), Movie.class);
            Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:9090/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        })
         .collect(Collectors.toList());

        //put them all to-gather


//        return Collections.singletonList(new CatalogItem("Trasformers", "Test", 4));
    }
}
