package com.ber.customerservice;

import com.ber.customerservice.entities.Customer;
import com.ber.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(CustomerRepository customerRepository){
		return  args ->{
			customerRepository.save(new Customer(null,"mohamed","mohamed@gmail.com"));
			customerRepository.save(new Customer(null,"bader","bader@gmail.com"));
			customerRepository.save(new Customer(null,"hanane","hanane@gmail.com"));
			customerRepository.findAll().forEach(customer -> {
				System.out.println(customer.toString());
			});


		};
	}
}
