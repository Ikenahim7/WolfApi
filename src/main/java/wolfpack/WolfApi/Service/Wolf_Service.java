package wolfpack.WolfApi.Service;

import org.hibernate.boot.model.source.spi.PluralAttributeKeySource;
import org.springframework.stereotype.Service;
import wolfpack.WolfApi.Model.Location;
import wolfpack.WolfApi.Model.Pack;
import wolfpack.WolfApi.Model.Wolf;

import java.util.ArrayList;
import java.util.List;

@Service
public class Wolf_Service {

    private List<Wolf> Wolf_list = new ArrayList<Wolf>();

    public List<Wolf> display_wolf_list()
    {
        return Wolf_list;
    }

    public boolean add_wolf(Wolf wolf) {
        for (Wolf _wolf : Wolf_list) {
            if (_wolf.getId().equals(wolf.getId())) {
                return false;
                }
            }
        Wolf_list.add(wolf);
        return true;
    }

    public boolean remove_wolf(String  id){
        for (Wolf _wolf : Wolf_list) {
            if (_wolf.getId().equals(id)) {
                Wolf_list.remove(_wolf);
                return true;
            }
        }
        return false;
    }

    public boolean update_wolf(String id, Wolf wolf) {
        boolean check = false;
        for (Wolf _wolf : Wolf_list) {
            if (_wolf.getId().equals(id)) {
                check=true;
                _wolf.setName(wolf.getName());
                _wolf.setBirthDay(wolf.getBirthDay());
                _wolf.setGender(wolf.getGender());
                System.out.println(check);
                return true;
            }
        }
        System.out.println(check);
        return false;
    }

    public boolean update_wolf_location(String id, Location location) {
        for (Wolf _wolf : Wolf_list) {
            if (_wolf.getId().equals(id)) {
                _wolf.setLatitude(location.getLatitude());
                _wolf.setLongitude(location.getLongitude());
                return true;
            }
        }
        return false;
    }






}
