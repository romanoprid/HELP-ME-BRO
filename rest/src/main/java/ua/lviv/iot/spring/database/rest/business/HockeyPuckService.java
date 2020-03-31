package ua.lviv.iot.spring.database.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.database.rest.dataaccess.HockeyPuckRepository;
import ua.lviv.iot.spring.database.rest.HockeyPuck;

import java.util.List;

@Service
public class HockeyPuckService {
    @Autowired
    private HockeyPuckRepository hockeyPuckRepository;

    public HockeyPuck addHockeyPuck(HockeyPuck hockeyPuck){
        return hockeyPuckRepository.save(hockeyPuck);
    }


    public List<HockeyPuck> getAllHockeyPucks(){
        List<HockeyPuck> list = hockeyPuckRepository.findAll();
        for (HockeyPuck d: list
        ) {
            System.out.println(d);
        }
        return hockeyPuckRepository.findAll();
    }


    public HockeyPuck getHockeyPuck(int id){

        if (hockeyPuckRepository.existsById(id)){
            System.out.println(hockeyPuckRepository.getOne(id));
            HockeyPuck hockeyPuck = (HockeyPuck) hockeyPuckRepository.getOne(id);
            return hockeyPuck;
        }

        return null;
    }

    public boolean deleteHockeyPuck(int id){
        if (hockeyPuckRepository.existsById(id))  {
            hockeyPuckRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseEntity<HockeyPuck> updateHockeyPuck(HockeyPuck hockeyPuck){
            HockeyPuck previousHockeyPuck = null;
        HttpStatus httpStatus;
        if(hockeyPuckRepository.existsById(hockeyPuck.getId())){
            previousHockeyPuck = hockeyPuckRepository.getOne(hockeyPuck.getId());
            hockeyPuckRepository.deleteById(hockeyPuck.getId());
            hockeyPuckRepository.save(hockeyPuck);
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(previousHockeyPuck, httpStatus);
    }
}

