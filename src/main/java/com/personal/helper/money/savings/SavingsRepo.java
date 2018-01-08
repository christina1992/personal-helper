package com.personal.helper.money.savings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepo extends JpaRepository<Savings, Long> {
}
