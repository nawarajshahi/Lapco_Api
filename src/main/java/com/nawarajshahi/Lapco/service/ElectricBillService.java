package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.ElectricBill;
import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.repository.ElectricBillRepository;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class ElectricBillService {

    private static final Logger logger = LogManager.getLogger(ElectricBillService.class);

    //electric bill is set in cents/kWh
    private final double costPerkWh = 19.7/100.0; //19.7 cents per kWh

    @Autowired
    private ElectricBillRepository electricRepo;

    @Autowired
    private RestroomRepository restRepo;

    //create electric bill read for given restroom_id
    public ElectricBill createElectricBill(Long rest_id, ElectricBill electricBill){
        //check to see if Restroom exists first
        Restroom restroom = restRepo.findOne(rest_id);

        try{
            //if restroom is not null then add electric bill details provided
            if(restroom !=null){
                logger.info("Restroom exists, creating water bill for restroomId: " + rest_id);
                double lowerLimit = 10;
                double upperLimit = 10000;
                double usedQty = lowerLimit + new Random().nextDouble() * (upperLimit - lowerLimit);

                electricBill.setRestroom(restroom);
                electricBill.setBillDate(electricBill.getBillDate());
                electricBill.setUsedQty(Math.round(usedQty*100.0)/100.0); //this ensures 2 decimal places
                electricBill.setTotalCost(Math.round(usedQty*costPerkWh*100.0)/100.0);
                logger.info("Completed setting all water bill details.");

                return electricBill;
            }
            logger.error("Restroom doesn't exist, returning null value.");
            return null;
        }catch (Exception e){
            logger.error("Error creating water bill read for given restroom.");
            throw e;
        }
    }
























}
