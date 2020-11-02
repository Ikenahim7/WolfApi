package wolfpack.WolfApi.Model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pack {

    private  String id;

    @NotNull(message = "Please provide a name")
    private String name;

    @NotNull(message = "Please provide a country")
    private String country;

    private List<Wolf> wolfList = new ArrayList<>();

    public Pack(@NotNull String name, @NotNull String country) {
        this.id = id!=null ? id : UUID.randomUUID().toString();
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public List<Wolf> getWolfList() {
        return wolfList;
    }
}
