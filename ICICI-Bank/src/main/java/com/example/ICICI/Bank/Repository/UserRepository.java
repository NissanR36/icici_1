package com.example.ICICI.Bank.Repository;

import com.example.ICICI.Bank.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int accountno);

}
