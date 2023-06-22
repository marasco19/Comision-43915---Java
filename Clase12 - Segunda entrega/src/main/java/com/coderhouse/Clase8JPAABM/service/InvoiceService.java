package com.coderhouse.Clase8JPAABM.service;


import com.coderhouse.Clase8JPAABM.model.*;
import com.coderhouse.Clase8JPAABM.repository.ClientRepository;
import com.coderhouse.Clase8JPAABM.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private ClientService clientService;
    public InvoiceDTO postInvoice (RequestInvoice requestInvoice) throws Exception {

        //Buscamos al cliente a través de su id
        Client clientExist = clientService.getClient(requestInvoice.getClient_id());
        if(clientExist == null) {
            throw new Exception("El cliente no existe");
        }
        //Buscamos los productos
        List<Product> productList = productService.getProductsById(requestInvoice.getProduct_list());
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            int requestedQuantity = requestInvoice.getProduct_list().get(i).getQuantity();
            if (product.getStock() < requestedQuantity) {
                throw new Exception("No hay suficiente stock para el producto: " + product.getDescription());
            }
        }

        //Calculo del total
        double total = 0;
        int i = 0;
        for (Product product:
                productList) {
            total += product.getPrice() * requestInvoice.getProduct_list().get(i).getQuantity();
            i++;
        }

        //Instanciamos un objeto invoice
        Invoice invoiceCreated = new Invoice();

        //Setteamos la fecha del invoice
        invoiceCreated.setCreated_at(new Date().toString());

        //Setteamos al cliente dentro del invoice
        invoiceCreated.setClient(clientExist);

        invoiceCreated.setTotal(total);
        //Guardamos el invoice antes de guardar el detalle
        invoiceCreated = invoiceRepository.save(invoiceCreated);

        //Settamos los invoice_details y los guardamos
        i = 0;
        for (Product productForDetail:
                productList) {
            InvoiceDetail newInvoice = new InvoiceDetail();
            newInvoice.setPrice(productForDetail.getPrice());
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productForDetail);
            newInvoice.setQuantity(requestInvoice.getProduct_list().get(i).getQuantity());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            i++;
        }
        //actualizamos stock
        // Actualizar el stock de los productos
        for (int j = 0; j < productList.size(); j++) {
            Product product = productList.get(j);
            int requestedQuantity = requestInvoice.getProduct_list().get(j).getQuantity();
            int updatedStock = product.getStock() - requestedQuantity;
            product.setStock(updatedStock);
            productService.updateStock(product);
        }
        //Por último retornamos el DTO
        return new InvoiceDTO(
                invoiceCreated.getId(),
                invoiceCreated.getCreated_at(),
                invoiceCreated.getTotal()
        );
    }

    public List<InvoiceDTO> getInvoicesByClientId (int clientId) throws Exception {
        return invoiceRepository.getInvoicesByClientById(clientId);
    }

    public InvoiceWithDetailsDTO getInvoiceById (int invoice_id) throws Exception {
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
        if (invoiceFound.isEmpty()) {
            throw new Exception("Invoice not found");
        }

        List<InvoiceDetailDTO> invoice_details = invoiceDetailService.getInvoiceDetailsByInvoiceId(invoice_id);

        return new InvoiceWithDetailsDTO(
                invoiceFound.get().getClient(),
                invoiceFound.get().getId(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal(),
                invoice_details
        );


    }
}