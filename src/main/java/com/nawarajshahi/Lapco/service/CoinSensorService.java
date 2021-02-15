package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.repository.CoinSensorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CoinSensorService {

    private static final Logger logger = LogManager.getLogger(CoinSensorService.class);

    //access CoinSensorRepository to perform CRUD operations on CoinSensor
    private CoinSensorRepository coinRepo;

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
        return coinRepo.findAll();
    }

    //create coin-read
    public CoinSensor createCoinRead(CoinSensor coinSensor){
        return coinRepo.save(coinSensor);
    }

    //update coin-read instance for coin CoinSensor
    public CoinSensor updateCoinRead(CoinSensor coinSensor, Long read_id) throws Exception{
        try{
            CoinSensor oldCoinSensor = coinRepo.findOne(read_id);
            oldCoinSensor.setRestroom(coinSensor.getRestroom());
            oldCoinSensor.setSensorId(coinSensor.getSensorId());
            oldCoinSensor.setMessage(coinSensor.getMessage());
            oldCoinSensor.setReadDatetime(LocalDateTime.now());
            oldCoinSensor.setNoOfQuarters(1);
            logger.info("Successfully updated the Coin_read transaction " + read_id);
            return coinRepo.save(oldCoinSensor);
        }catch (Exception e){
            logger.error("Exception occurred while trying to update the coin read with id " + read_id, e);
            throw new Exception("Unable to update the coin read transaction.");
        }
    }

    //delete coin_read transaction
    public void deleteCoinRead(Long read_id) throws Exception{
        try{
            coinRepo.delete(read_id);
            logger.info("Successfully deleted the coin read with id: " + read_id);
        }catch (Exception e){
            logger.error("Exception occurred while updating the coin read with id " + read_id, e);
            throw new Exception("Unable to delete the coin-read with id " + read_id);
        }
    }



}
