package com.park.parkingmanagment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.park.parkingmanagment.model.AmountReceipt;
@Repository
public interface AmountReceiptRepository extends CrudRepository<AmountReceipt, String>{

}
