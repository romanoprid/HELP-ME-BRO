package ua.lviv.iot.spring.database.rest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.database.rest.HockeyPuck;
import ua.lviv.iot.spring.database.rest.business.HockeyPuckService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RequestMapping("/hockeypucks")
@RestController
@RequiredArgsConstructor

public class HockeyPuckController {

    private Map<Integer, HockeyPuck> hockeyPucks = new HashMap<>();

    private AtomicInteger idCounter = new AtomicInteger();

    private  HockeyPuckService hockeyPuckService;



    @GetMapping
    public List<HockeyPuck> getHockeyPucks() {
//        return new ArrayList<>(directors.values());
        return hockeyPuckService.getAllHockeyPucks();
    }

    @GetMapping(path = "/{id}")
    public HockeyPuck getHockeyPuck(final @PathVariable("id") Integer hockeyPuckId) {
//        return directors.get(studentId);
        return hockeyPuckService.getHockeyPuck(hockeyPuckId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public HockeyPuck createHockeyPuck(final @RequestBody HockeyPuck hockeyPuck) {
//        hockeyPuck.setId(idCounter.incrementAndGet());
//        hockeyPucks.put(hockeyPuck.getId(), hockeyPuck);
//        return hockeyPuck;
        return hockeyPuckService.addHockeyPuck(hockeyPuck);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HockeyPuck> deleteHockeyPuck(@PathVariable("id") int hockeyPuckId) {
        HttpStatus status = hockeyPuckService.deleteHockeyPuck(hockeyPuckId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HockeyPuck> updateHockeyPuck(final @PathVariable("id") Integer hockeyPuckId,
                                                     final @RequestBody HockeyPuck hockeyPuck) {
//        directorService.updateDirector(director);
//        HttpStatus status;
//        Director previous = null;
//        director.setId(directorId);
//        if (directors.containsKey(directorId)) {
//            previous = directors.put(directorId, director);
//            status = HttpStatus.OK;
//        } else {
//            status = HttpStatus.NOT_FOUND;
//        }
//        return new ResponseEntity(previous, status);
        hockeyPuck.setId(hockeyPuckId);
        return hockeyPuckService.updateHockeyPuck(hockeyPuck);
    }
}

