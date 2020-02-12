package com.mastek.bankapp.demo.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mastek.bankapp.demo.entities.Transfer;

public interface TransferJPADAO extends MongoRepository<Transfer, Integer> {

}
