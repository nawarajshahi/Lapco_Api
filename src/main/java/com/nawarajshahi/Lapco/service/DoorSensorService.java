package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.DoorSensor;
import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.repository.DoorSensorRepository;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class DoorSensorService {
    private static final Logger logger = LogManager.getLogger(DoorSensorService.class);

    @Autowired private DoorSensorRepository doorRepo;

    @Autowired private RestroomRepository restRepo;

    //create door sensor read for specific restroom
    public DoorSensor createDoorRead(Long rest_id, DoorSensor doorSensor){
        //get the restroom with given rest_id
        Restroom restroom = restRepo.findOne(rest_id);
        try{
            if(restroom != null){
                logger.info("Restroom exists, and setting restroom details to the door sensor.");
                doorSensor.setRestroom(restroom);
                doorSensor.setDoorOpenTime(LocalDateTime.now());
                doorSensor.setDoorCloseTime(LocalDateTime.now().plusSeconds(8)); //door closes after 8 seconds.
                doorSensor.setMessage("Door opened & closed.");
                logger.info("Created door sensor read details.");
                return doorRepo.save(doorSensor);
            }
            logger.error("restroom does not exist, returning null");
            return null;
        }catch (Exception e){
            logger.error("Error occurred while creating door read details.");
            throw e;
        }
    }


}
