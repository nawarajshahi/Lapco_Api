package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.Address;
import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.repository.AddressRepository;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestroomService {
    private static final Logger logger = LogManager.getLogger(RestroomService.class);

    @Autowired
    private RestroomRepository repo;

    @Autowired
    private AddressRepository addRepo;

    //get restroom detail with restroom_id
    public Restroom getRestroomDetailById(Long restroom_id) throws Exception {
        try {
            logger.info("Successfully retrieved restroom with id: " + restroom_id);
            return repo.findOne(restroom_id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to retrieve address with id: " + restroom_id);
            throw e;
        }
    }

    //get restroom details
    public Iterable<Restroom> getRestroomDetails(){
        logger.info("Successfully retrieved all the restroom details.");
        return repo.findAll();
    }

    //create a restroom
    public Restroom createRestroom(Restroom restroom) {
        logger.info("Successfully created restroom");
        return repo.save(restroom);
    }

    //update a restroom detail with restroom_id
    public Restroom updateResroom(Restroom restroom, Long restroom_id) throws Exception{
        try{
            Restroom oldRestroom = repo.findOne(restroom_id);
            oldRestroom.setAddress(restroom.getAddress());
            oldRestroom.setSerialNo(restroom.getSerialNo());
            oldRestroom.setModelNo(restroom.getModelNo());
            oldRestroom.setDateInstalled(restroom.getDateInstalled());
            oldRestroom.setTotalCostOfProduction(restroom.getTotalCostOfProduction());
            oldRestroom.setTotalCostOfInstallation(restroom.getTotalCostOfInstallation());
            logger.info("Successfully updated the restroom details. ");
            return repo.save(oldRestroom);
        }catch (Exception e){
            logger.error("Exception occurred while trying to update the restroom details.");
            throw new Exception("Unable to update the restroom details.");
        }
    }

    //delete a restroom
    public void deleteRestroom(Long restoom_id) throws Exception{
        try{
            logger.info("Successfully deleted the restroom with id " + restoom_id);
            repo.delete(restoom_id);
        } catch (Exception e){
            logger.error("Exception occured while trying to delete the restroom with id: " + restoom_id);
            throw e;
        }
    }

}
