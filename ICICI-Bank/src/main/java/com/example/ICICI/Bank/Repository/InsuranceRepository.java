package com.example.ICICI.Bank.Repository;

import com.example.ICICI.Bank.POJO.Insurance;
import com.example.ICICI.Bank.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {


}
