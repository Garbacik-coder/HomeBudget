package com.garbacik.homebudget.repository;

import com.garbacik.homebudget.model.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends JpaRepository<Spending,Integer> {
}
