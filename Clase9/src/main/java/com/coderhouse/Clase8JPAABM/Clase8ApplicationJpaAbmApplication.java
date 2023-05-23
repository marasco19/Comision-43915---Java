package com.coderhouse.Clase8JPAABM;

import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.model.Invoice;
import com.coderhouse.Clase8JPAABM.model.InvoiceDetails;
import com.coderhouse.Clase8JPAABM.model.Product;
import com.coderhouse.Clase8JPAABM.repository.ClientRepository;
import com.coderhouse.Clase8JPAABM.repository.InvoiceRepository;
import com.coderhouse.Clase8JPAABM.repository.InvoiceDetailsRepository;
import com.coderhouse.Clase8JPAABM.repository.ProductRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
public class Clase8ApplicationJpaAbmApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDetailsRepository invoiceDetailsRepository;


	public static void main(String[] args) {
		SpringApplication.run(Clase8ApplicationJpaAbmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");
		try {
			/* Instancio un nuevo Cliente */
			Client cliente1 = new Client();
			cliente1.setName("Mariano");
			cliente1.setLastname("Ramos");
			cliente1.setDocnumber("315556666");
			/* Guardo el Cliente en la BD */
			this.clientRepository.save(cliente1);

			/* Instancio un nuevo Cliente */
			Client cliente2 = new Client();
			cliente2.setName("Juan");
			cliente2.setLastname("Perez");
			cliente2.setDocnumber("28455999");
			/* Guardo el Cliente en la BD */
			this.clientRepository.save(cliente2);

			/* Instancio un nuevo Cliente */
			Client cliente3 = new Client();
			cliente3.setName("Pedro");
			cliente3.setLastname("Lima");
			cliente3.setDocnumber("24587963");
			/* Guardo el Cliente en la BD */
			this.clientRepository.save(cliente3);

			List<Client> clientes = this.clientRepository.findByNameLike("%ua%");
			System.out.println(clientes.size());
			printClientes(clientes);

			List<Client> clientes2 = this.clientRepository.getByNameOrderedByLastnameJPQL("Pedro");
			System.out.println(clientes2.size());
			printClientes(clientes2);

			List<Client> clientes3 = this.clientRepository.getByNameOrderedByLastnameNativeQuery("Pedro");
			System.out.println(clientes3.size());
			printClientes(clientes3);

			/* Instancio un nuevo producto 1*/
			Product taza = new Product();
			taza.setCode("AAAD54888");
			taza.setDescription("400 ml");
			taza.setPrice(10);
			taza.setStock(100);
			/* Guardo el producto en la BD */
			this.productoRepository.save(taza);

			/* Instancio un nuevo producto 2*/
			Product remera = new Product();
			remera.setCode("BBBVVV8888");
			remera.setDescription("Adidas");
			remera.setPrice(5000);
			remera.setStock(50);
			/* Guardo el producto en la BD */
			this.productoRepository.save(remera);

			/* Instancio un nuevo producto 3*/
			Product camisa = new Product();
			camisa.setCode("EEERRR5555");
			camisa.setDescription("Newton");
			camisa.setPrice(6000);
			camisa.setStock(70);
			/* Guardo el producto en la BD */
			this.productoRepository.save(camisa);

			Optional<Product> productoGuardado1 = this.productoRepository.findById(1);
			Optional<Product> productoGuardado2 = this.productoRepository.findById(2);
			Optional<Product> productoGuardado3 = this.productoRepository.findById(3);

			System.out.println(productoGuardado1);
			System.out.println(productoGuardado2);
			System.out.println(productoGuardado3);

			Optional<Client> client1 = this.clientRepository.findById(1);

			Invoice invoice1 = new Invoice();
			client1.ifPresent(invoice1::setClient);
			invoice1.setCreated_at("13-05");
			invoice1.setTotal(500);
			this.invoiceRepository.save(invoice1);

			Invoice invoice2 = new Invoice();
			client1.ifPresent(invoice2::setClient);
			invoice2.setCreated_at("14-05");
			invoice2.setTotal(700);
			this.invoiceRepository.save(invoice2);

			Optional<Client> client2 = this.clientRepository.findById(2);

			Invoice invoice3 = new Invoice();
			client2.ifPresent(invoice3::setClient);
			invoice3.setCreated_at("16-05");
			invoice3.setTotal(1000);
			this.invoiceRepository.save(invoice3);

			client1 = this.clientRepository.findById(1);
			System.out.println((client1.get().getInvoice()));


			Optional<Product> productoParaGuardar1 = this.productoRepository.findById(1);
			Optional<Invoice> facturaParaGuardar1 = this.invoiceRepository.findById(1);

			InvoiceDetails invoiceDetail1 = new InvoiceDetails();
			productoParaGuardar1.ifPresent(invoiceDetail1::setProduct);
			facturaParaGuardar1.ifPresent(invoiceDetail1::setInvoice);
			invoiceDetail1.setCantidad(100);
			invoiceDetail1.setPrecio(30);
			this.invoiceDetailsRepository.save(invoiceDetail1);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	static void printClientes (List<Client> listadoClientes) {
		for (Client cliente: listadoClientes
		) {
			System.out.println(cliente);
		}
	}

	static void printInvoices (List<Invoice> listadoFacturas) {
		for (Invoice factura: listadoFacturas
		) {
			System.out.println(factura);
		}
	}

}
