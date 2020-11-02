package wolfpack.WolfApi.Model;

import javax.validation.constraints.NotNull;

public class Location {

    @NotNull(message = "Please provide a latitude")
    private double latitude;

    @NotNull(message = "Please provide a longitude")
    private double longitude;

    public Location(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
