package com.inn.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inn.main.model.TicketFamily;

@Repository
public interface TicketFamilyRepository extends JpaRepository<TicketFamily,Integer>{

}
