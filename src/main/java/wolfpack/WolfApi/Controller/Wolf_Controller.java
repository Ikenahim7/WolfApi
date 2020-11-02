package wolfpack.WolfApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wolfpack.WolfApi.Model.Location;
import wolfpack.WolfApi.Model.Wolf;
import wolfpack.WolfApi.Service.Wolf_Service;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Wolf_Controller {

    @Autowired
    private Wolf_Service wolf_service;

    @RequestMapping("Wolf/wolf_list")
    public List<Wolf> All_wolfs()
    {
        return wolf_service.display_wolf_list();
    }

    @PostMapping(value = "Wolf/createwolf", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createwolf (@Valid @RequestBody Wolf wolf)   {

        var isAdded =  wolf_service.add_wolf(wolf);
        if (!isAdded)
        {
            return new ResponseEntity<>("Wolf is not created.", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(wolf, new HttpHeaders(), HttpStatus.OK);

    }

    @DeleteMapping(value = "Wolf/removewolf/{id}")
    public ResponseEntity<Long> deletewolf(@Valid @PathVariable String id)  {

        var isRemoved = wolf_service.remove_wolf(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "Wolf/updatewolf/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Wolf> updatewolf(@Valid @PathVariable String id, @Valid @RequestBody Wolf wolf_info) {
        var isUpdated = wolf_service.update_wolf(id, wolf_info);

        if (!isUpdated) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "Wolf/updatewolfLocation/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Wolf> updateWolfLocation (@PathVariable String id, @Valid @RequestBody Location location) {
        var islocationUpdated = wolf_service.update_wolf_location(id, location);

        if (!islocationUpdated) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }









}



