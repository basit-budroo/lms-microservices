package com.lms.persistence;

import java.util.List;
import java.util.UUID;

import javax.websocket.Decoder.Binary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.bean.Tbr;
@Repository
public interface TbrDao extends JpaRepository<Tbr, Integer> {
	List<Tbr> findByBookId(int i);
}
