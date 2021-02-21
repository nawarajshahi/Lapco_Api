package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.repository.CoinSensorRepository;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinSensorService implements Serializable {

    private static final Logger logger = LogManager.getLogger(CoinSensorService.class);

    //access CoinSensorRepository to perform CRUD operations on CoinSensor
    @Autowired
    private CoinSensorRepository coinRepo;

    @Autowired
    private RestroomRepository restroomRepository;

    public List<CoinSensor> getSensorsByRestroomId(Long rest_id){
        //find the restroom with rest_id provided
        Restroom restroom = restroomRepository.findOne(rest_id);
        try{
            if(!restroom.equals(null)){
                List<CoinSensor> coinSensors = new ArrayList<>();
                Iterable<CoinSensor> coinSensorsIter = coinRepo.findAll();
                for(CoinSensor sensor: coinSensorsIter){
                    if(sensor.getRestroom().getRestroomId().equals(rest_id)){
                        coinSensors.add(sensor);
                        System.out.println(sensor);
                    }
                }

                return coinSensors;
            }
            throw new Exception(" restroom with given id " + rest_id + " not found.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*
    //method to access CoinSensor transaction by coin_read id
    public CoinSensor getCoinSensorByReadId(Long read_id) throws Exception{
        try{
            logger.info("Successfully accessed coinSensor detail with coin_read_id " + read_id);
            return coinRepo.findOne(read_id);
        } catch(Exception e){
            logger.error("Error retrieving the coinSensor with coin_read_id " + read_id);
            throw e;
        }
    }

    //access all the coinSensor details
    public Iterable<CoinSensor> getAllCoinSensorDetails(){
        logger.info("Returned all the coinSensor details");
        return coinRepo.findAll();
    }

    //create coin-read
    public CoinSensor createCoinRead(CoinSensor coinSensor){
        
        return coinRepo.save(coinSensor);
    }

     */


}
