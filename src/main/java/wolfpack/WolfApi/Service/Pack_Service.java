package wolfpack.WolfApi.Service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wolfpack.WolfApi.Model.Pack;
import wolfpack.WolfApi.Model.Wolf;

import java.util.ArrayList;
import java.util.List;

@Service
public class Pack_Service {

    private List<Pack> Pack_list = new ArrayList<Pack>();

    public List<Pack> getPack_list() {
        return Pack_list;
    }
    private JSONObject json = new JSONObject();

    public boolean create_pack(Pack pack) {
        if(Pack_list.size()>0)
        {
            for (Pack _pack : Pack_list) {
                if (pack.getName().equals(_pack.getName()))
                {
                    return false;
                }
            }
        }
        Pack_list.add(pack);
        return true;
    }

    public boolean add_wolf_to_pack(String pack_id, Wolf wolf)
    {
        Pack pack = get_pack_by_id(pack_id);
        if (pack!=null)
        {
            pack.getWolfList().add(wolf);
            wolf.setPackname(pack.getName());
            return true;
        }
        return false;
    }

    public Pack get_pack_by_id(String pack_id)
    {
        if (Pack_list.size()>0)
        {
            for(Pack _pack: Pack_list)
            {
                if(_pack.getId().equals(pack_id))
                {
                   return _pack;
                }
            }
        }
        return null;
    }

    public boolean remove_wolf_from_Pack(String pack_id, String wolf_id)  {

        Pack pack = get_pack_by_id(pack_id);
        System.out.println(wolf_id);
        if (pack!=null)
        {
           for (Wolf _wolf: pack.getWolfList())
           {
               if(_wolf.getId().equals(wolf_id))
               {
                   pack.getWolfList().remove(_wolf);
                   return true;
               }
           }
        }
        return false;
    }




}
