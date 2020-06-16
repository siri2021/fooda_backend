package it.vkod.fooda.store.server.models.store.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(value = "store")
public class FoodaStore implements Serializable {

    @Id
    private Long id;
    private String name;
    private String consumerSecret;
    private String consumerKey;
    private String currency;

    private String address;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private Double longitude;
    private Double latitude;

    private String homeUrl;
    private String siteUrl;
    private String port;

    private static final Double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;

    public FoodaStore empty() {
        return null;
    }

    public enum DistanceUnit {
        KM, MILES
    }

    // return distance between this location and that location
    // measured in statute miles
    public Double distanceTo(FoodaStore that, DistanceUnit unit) {
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        final double result = STATUTE_MILES_PER_NAUTICAL_MILE * 60 * Math.toDegrees(angle);
        return unit.equals(DistanceUnit.MILES) ? result : milesToKm(result);
    }

    private static Double milesToKm(double distanceInMiles) {
        return distanceInMiles * 1.60934;
    }
}
