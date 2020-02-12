package com.mastek.bankapp.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankapp.demo.entities.Account;
@Repository
public interface AccountJPADAO extends CrudRepository<Account, Integer>{

}
