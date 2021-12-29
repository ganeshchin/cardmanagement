package com.cardmanagementsystemm.cardmanagementsystemm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.cardmanagementsystemm.cardmanagementsystemm.controller.dao.DBConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = DBConfiguration.class)
public class CardmanagementsystemmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardmanagementsystemmApplication.class, args);
	}

}
