package wolfpack.WolfApi.Model;

import java.util.UUID;
import javax.validation.constraints.NotNull;

public class Wolf {

    private String id ;

    @NotNull(message = "Please provide a name")
    private String name;

    @NotNull(message = "Please provide a gender")
    private Gender gender;

    @NotNull(message = "Please provide a birthDay")
    private String birthDay;

    @NotNull(message = "Please provide a latitude")
    private double latitude;

    @NotNull(message = "Please provide a longitude")
    private double longitude;

    private String packname;


    public Wolf(@NotNull String name, @NotNull Gender gender, @NotNull String birthDay, @NotNull double latitude, @NotNull double longitude, String packname)
    {
        this.id = id!=null ? id : UUID.randomUUID().toString();
        this.name= name;
        this.gender= gender;
        this.birthDay= birthDay;
        this.latitude= latitude;
        this.longitude= longitude;
        this.packname= packname;
    }

    public String getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }

    public String getName() {
        return name;
    }

    public String getPackname() {
        return packname;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
