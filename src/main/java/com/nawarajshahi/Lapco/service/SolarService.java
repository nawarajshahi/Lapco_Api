package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.Entity.Solar;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import com.nawarajshahi.Lapco.repository.SolarRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SolarService {
    private static final Logger logger = LogManager.getLogger(RestroomService.class);

    @Autowired
    private SolarRepository solarRepo;

    @Autowired
    private RestroomRepository restRepo;

    //create solar read by restroom_id
    public Solar createSolarRead(Long rest_id, Solar solar) throws Exception {
        //check to see if restroom exists
        Restroom restroom = restRepo.findOne(rest_id);
        try{
            if(restroom != null){
                logger.info("Restroom exists, and setting restroom details to the solar sensor.");
                double lowerLimit = 20;
                double upperLimit = 200D;
                double quantity = lowerLimit + new Random().nextDouble() * (upperLimit - lowerLimit);
                solar.setGeneratedQty(quantity);
                solar.setMessage("panel active.");
                return solarRepo.save(solar);
            }
            logger.error("restroom does not exist, returning null");
            throw new Exception("Restroom doesn't exist, returning null.");
        }catch(Exception e){
            logger.error("Error creating solar read");
            throw e;
        }
    }
}
