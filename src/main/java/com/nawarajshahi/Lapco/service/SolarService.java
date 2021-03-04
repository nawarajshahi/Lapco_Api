package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.Entity.Solar;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import com.nawarajshahi.Lapco.repository.SolarRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class SolarService {
    private static final Logger logger = LogManager.getLogger(RestroomService.class);

    @Autowired
    private SolarRepository solarRepo;

    @Autowired
    private RestroomRepository restRepo;

    //create solar read by restroom_id
    public Solar createSolarRead(Solar solar, Long[] restroomIds) throws Exception {
        Solar newSolar = new Solar();

        //set solar read info to the solar entity
        newSolar.setPanelId(solar.getPanelId());
        newSolar.setGeneratedQty(solar.getGeneratedQty());
        newSolar.setMessage(solar.getMessage());

        //retrieve all restrooms with given restroom Ids
        Iterable<Restroom> restroomIterable = restRepo.findAll(Arrays.asList(restroomIds));
        Set<Restroom> restrooms = new HashSet<>();

        //set solar read details for each restrooms retrieved above
        for(Restroom restroom: restroomIterable){
            restroom.getSolars().add(newSolar);
            restrooms.add(restroom);
        }

        //add all restrooms info to the given solar read
        newSolar.getRestrooms().addAll(restrooms);
        return solarRepo.save(newSolar);
    }

    //get solar read
    public Solar getSolarReadById(Long solar_read_id){
        return solarRepo.findOne(solar_read_id);
    }

    //get all solar reads
    public Iterable<Solar> getAllSolarReads(){
        return solarRepo.findAll();
    }

    //get restrooms that are coverd by given read_id
    public Set<Restroom> restroomsCoveredBySolarReadId(Long solar_read_id){
        Solar solar = solarRepo.findOne(solar_read_id);
        return solar.getRestrooms();
    }


}
