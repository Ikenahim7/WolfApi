package wolfpack.WolfApi.Controller;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wolfpack.WolfApi.Model.Pack;
import wolfpack.WolfApi.Model.Wolf;
import wolfpack.WolfApi.Service.Pack_Service;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Pack_Controller {

    @Autowired
    private Pack_Service pack_service;

    @RequestMapping("Pack/pack_list")
    public List<Pack> all_Packs()
    {
        return pack_service.getPack_list();
    }

    @PostMapping(value = "Pack/create_pack", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create_Pack (@Valid @RequestBody Pack pack)   {

        var isAdded =  pack_service.create_pack(pack);
        if (!isAdded)
        {
            return new ResponseEntity<>("Pack is not created.", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(pack, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "Pack/add_wolf_to_Pack/{pack_id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> add_wolf_to_pack (@PathVariable String pack_id, @RequestBody @Valid Wolf wolf)   {

        var added =pack_service.add_wolf_to_pack(pack_id,wolf);
        if (!added)
        {
            return new ResponseEntity<>("Wolf is not added.", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(wolf, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "Pack/remove_wolf_from_pack/{pack_id}/wolf/{wolf_id}")
    public ResponseEntity<?> remove_wolf_from_Pack (@PathVariable String pack_id,@PathVariable String wolf_id) throws JSONException {

        var removed = pack_service.remove_wolf_from_Pack(pack_id, wolf_id);
        if (!removed)
        {
            return new ResponseEntity<>("Wolf is not removed.", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Wolf has been removed from the pack: " + pack_id, new HttpHeaders(), HttpStatus.OK);

    }


}
