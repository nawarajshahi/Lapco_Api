package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.Entity.WaterBill;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import com.nawarajshahi.Lapco.repository.WaterBillRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WaterBillService {

    private static final Logger logger = LogManager.getLogger(WaterBillService.class);

    //water is read in gallons and hence cost is dollar/gallon
    private final double costPerGallon = 0.4264/100; //cost per 100 gallon is 0.4264



    @Autowired
    private WaterBillRepository waterRepo;

    @Autowired
    private RestroomRepository restRepo;

    //create water bill for restroom with given rest_id
    public WaterBill createWaterBillByRestroomId(Long rest_id, WaterBill waterBill) throws Exception {
        Restroom restroom = restRepo.findOne(rest_id);
        try{
            if(restroom !=null){
                logger.info("Restroom exists, and setting restroom details to the water bill");
                double lowerLimit = 100;
                double upperLimit = 10000;
                double usedQty = lowerLimit + new Random().nextDouble() * (upperLimit - lowerLimit);
                waterBill.setRestroom(restroom);
                waterBill.setBillDate(waterBill.getBillDate());
                waterBill.setUsedQty((double) Math.round(usedQty*100.0)/100.0);
                waterBill.setTotalCost((double) Math.round(usedQty*costPerGallon *100.0)/100.0);
                logger.info("Finished setting all the water bill details.");

                return waterRepo.save(waterBill);
            }
            throw new Exception("Error creating water bill.");
        }catch (Exception e){
            logger.error("Unable to create water bill");
            throw e;
        }
    }

    //read water bills for given restroom id
    public List<WaterBill> getWaterBillsByRestroomId(Long rest_id){
        //get the restroom with rest_id
        Restroom restroom = restRepo.findOne(rest_id);
        try{
            if(restroom !=null){
                logger.info("Restroom exists, extracting water bills associated with restroom id: " + rest_id);
                List<WaterBill> waterBills = new ArrayList<>();
                Iterable<WaterBill> waterBillIterable = waterRepo.findAll();
                for (WaterBill waterBill : waterBillIterable) {
                    if(waterBill.getRestroom().getRestroomId() == rest_id){
                        waterBills.add(waterBill);
                    }
                }
                logger.info("Returning all the water bills  with restroom id: " + rest_id);
                return waterBills;
            }
            logger.error("Could not find restroom, returning null value");
            return null;
        }catch (Exception e){
            logger.error("Error accessing water bills for given restroom");
            throw e;
        }
    }

    public void deleteWaterBillById(Long bill_id){
       try{

           waterRepo.delete(bill_id);
       }catch (Exception e){
           e.printStackTrace();
       }
    }


}
