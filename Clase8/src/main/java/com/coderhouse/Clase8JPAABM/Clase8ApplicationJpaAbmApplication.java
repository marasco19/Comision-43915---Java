package com.coderhouse.Clase8JPAABM;

import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.model.Product;
import com.coderhouse.Clase8JPAABM.repository.ClientRepository;
import com.coderhouse.Clase8JPAABM.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Clase8ApplicationJpaAbmApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private ClientRepository clientRepository;


	public static void main(String[] args) {
		SpringApplication.run(Clase8ApplicationJpaAbmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");
        /* Instancio un nuevo producto */
		Product taza = new Product();
		taza.setCode("AAAD54888");
		taza.setDescription("400 ml");
		taza.setPrice(10);
		taza.setStock(100);
		/* Guardo el producto en la BD */
		this.productoRepository.save(taza);
		/* Busco el producto guardado por Id */
		Optional<Product> productoObtenido = this.productoRepository.findById(1);
		/* Si existe lo muestro por pantalla */
		if(productoObtenido.isPresent()) System.out.println(productoObtenido.get());
		else System.out.println("Producto no encontrado");

		/* Instancio un nuevo Cliente */
		Client clienteNuevo = new Client();
		clienteNuevo.setName("Mariano");
		clienteNuevo.setLastname("Ramos");
		clienteNuevo.setDocnumber("315556666");
		/* Guardo el Cliente en la BD */
		this.clientRepository.save(clienteNuevo);
		/* Consulto el cliente por Id */
		Optional<Client> clienteObtenido = this.clientRepository.findById(1);
		/* Si existe lo muestro por pantalla */
		if(clienteObtenido.isPresent()) System.out.println(clienteObtenido.get());
		else System.out.println("Cliente no encontrado");

	}
}
