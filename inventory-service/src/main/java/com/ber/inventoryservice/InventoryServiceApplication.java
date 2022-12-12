package com.ber.inventoryservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(ProductRepository inventoryRepository){
		return args -> {
		inventoryRepository.save(new Product(null,"Ordinateur",126,3));
		inventoryRepository.save(new Product(null,"Portable",123,4));
		inventoryRepository.save(new Product(null,"Chargeur",192,9));
		inventoryRepository.findAll().forEach(product -> {
			System.out.println(product.toString());
		});
		};
	}
}

@Entity @Data
@AllArgsConstructor @NoArgsConstructor  @ToString
 class Product{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private double quantity;

}
@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product,Long>{

}