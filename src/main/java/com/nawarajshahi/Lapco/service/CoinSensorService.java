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
    private RestroomService restroomService;

    //create coin read
    public CoinSensor createCoinRead(Long restroom_id, CoinSensor coinsensor) throws Exception {
        try{
            Restroom restroom = restroomService.getRestroomDetailById(restroom_id);
            if(restroom !=null){
                logger.info("Restroom exists, adding coin read details.");
                coinsensor.setRestroom(restroom);
                coinsensor.setSensorId(coinsensor.getSensorId());
                coinsensor.setNoOfQuarters(1);
                coinsensor.setReadDatetime(LocalDateTime.now());
                coinsensor.setMessage("Accepted.");
                coinRepo.save(coinsensor);

                logger.info("Added coin read details and returning the coin sensor");
                return coinsensor;

            }else{
                logger.error("Restroom doesn't exist, returning null.");
                return null;
            }
        }catch (Exception e){
            logger.error("Error occurred creating coin read.");
            throw e;
        }
    }


    //get all coin read details by restroom_id
    public List<CoinSensor> getReadsByRestroomId(Long rest_id) throws Exception {
        //get the restroom with given rest_id first
        List<CoinSensor> coinSensors = new ArrayList<>();
        try{
            Restroom restroom = restroomService.getRestroomDetailById(rest_id);
            if(restroom !=null){
                logger.info("Restroom exists, returning coin read details with restroom Id: " + rest_id);

                Iterable<CoinSensor> coinSensorIterable = coinRepo.findAll();
                for (CoinSensor coinSensor : coinSensorIterable) {
                    if(coinSensor.getRestroom().getRestroomId() == rest_id){
                        coinSensors.add(coinSensor);
                    }
                }
                logger.info("Added all coin read details with restroom id: " + rest_id);
            }else{
                logger.error("Restroom doesn't exist, please ensure details are correct. Returning null");
            }

        }catch (Exception e){
            logger.error("Error occurred while reading coin read details.");
            throw e;
        }
        logger.info("Returning all coin read details with restroom id: " + rest_id);
        return coinSensors;
    }



}
