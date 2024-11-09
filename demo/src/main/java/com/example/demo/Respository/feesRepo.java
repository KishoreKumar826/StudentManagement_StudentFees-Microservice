package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Domain.Studentfees;

public interface feesRepo extends JpaRepository<Studentfees, Integer> {

}
