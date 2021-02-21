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
    private static final Logger logger = LogManager.getLogger(AddressService.class);

    @Autowired private DoorSensorRepository doorRepo;

    @Autowired RestroomService restService;

    @Autowired RestroomRepository restRepo;

    //create door sensor read for specific restroom
    public DoorSensor createDoorRead(Long rest_id, DoorSensor doorSensor){
        //get the restroom with given rest_id
        Restroom restroom = restRepo.findOne(rest_id);
            //check to see if the restroom exists
            if(restroom != null){
                logger.info("Restroom exists, and setting restroom details to the door sensor.");
                doorSensor.setRestroom(restroom);
                doorSensor.setDoorOpenTime(LocalDateTime.now());
                doorSensor.setDoorCloseTime(LocalDateTime.now().plusSeconds(5));
                doorSensor.setMessage("Door opened and closed.");
                return doorRepo.save(doorSensor);
            }
            logger.error("restroom does not exist, returning null");
            return null;
    }

    //read all the door sensor data for given restroom_id
    public List<DoorSensor> getDoorReadsByRestroomId(Long rest_id){
        //first obtain the restroom with given rest_id
        Restroom restroom = restRepo.findOne(rest_id);

        List<DoorSensor> doorSensors = new ArrayList<>();

        Iterable<DoorSensor> doorSensorIterable = doorRepo.findAll();
        for(DoorSensor sensor: doorSensorIterable){
            if(sensor.getRestroom().getRestroomId()== restroom.getRestroomId()){
                doorSensors.add(sensor);
            }
        }
        return doorSensors;
    }










}
