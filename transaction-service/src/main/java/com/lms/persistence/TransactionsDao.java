package com.lms.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.bean.Transactions;
@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Integer> {
}
