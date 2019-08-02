package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    TrackService trackService;
    Track track;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {

        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }

        catch(TrackAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer id) throws TrackNotFoundException {

        ResponseEntity responseEntity;

        trackService.deleteTrack(track);
        responseEntity = new ResponseEntity("Delete Successfull", HttpStatus.OK);
        return responseEntity;

    }


    @PutMapping("/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;


        trackService.updateTrack(track);
        responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.CREATED);
        return responseEntity;
    }



    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
       /* System.out.println(trackService.getByTrackName("good").toString());
        System.out.println(trackService.getTrackByNameSortByName("good").toString());
*/        return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);

    }

}
