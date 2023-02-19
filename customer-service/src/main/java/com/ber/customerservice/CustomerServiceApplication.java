package com.ber.customerservice;

import com.ber.customerservice.entities.Customer;
import com.ber.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CustomerServiceApplication {

	//@Autowired
	//RepositoryRestConfiguration restConfiguration,

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(CustomerRepository customerRepository){
		return  args ->{
		//	restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null,"mohamed","mohamed@gmail.com"));
			customerRepository.save(new Customer(null,"bader","bader@gmail.com"));
			customerRepository.save(new Customer(null,"hanane","hanane@gmail.com"));
			customerRepository.findAll().forEach(customer -> {
				System.out.println(customer.toString());

			});

		};
	}
}
