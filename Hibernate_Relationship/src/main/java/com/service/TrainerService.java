package com.service;

import com.bean.Trainer;
import com.dao.TrainerDao;

public class TrainerService {
	
TrainerDao td = new TrainerDao();
    
    public String storeTrainerInfo(Trainer tr) {
        if(td.storeTrainerInfo(tr)>0) {
            return "Trainer record stored successfully";
        }else {
            return "Trainer record didn't store";
        }
    }

}
