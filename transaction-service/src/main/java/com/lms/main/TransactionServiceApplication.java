package com.lms.main;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lms.bean.Tbr;
import com.lms.bean.Transactions;
import com.lms.persistence.TbrDao;
import com.lms.persistence.TransactionsDao;


@SpringBootApplication(scanBasePackages = "com.lms")
@EntityScan(basePackages = "com.lms.bean")
@EnableJpaRepositories(basePackages = "com.lms.persistence")
@EnableEurekaClient
public class TransactionServiceApplication implements CommandLineRunner {
	
	@Autowired
	private TbrDao tbr;
	@Autowired
	private TransactionsDao transaction;
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		tbr.save(new Tbr(111,10002,"2008-11-11","2008-11-17","2022-11-19",0));
//		transaction.save(new Transactions(2002));
		
	}
}
