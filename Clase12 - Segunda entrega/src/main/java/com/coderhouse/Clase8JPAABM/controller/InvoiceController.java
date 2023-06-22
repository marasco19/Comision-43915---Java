package com.coderhouse.Clase8JPAABM.controller;


import com.coderhouse.Clase8JPAABM.middleware.ResponseHandler;
import com.coderhouse.Clase8JPAABM.model.*;
import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.service.InvoiceService;
import com.coderhouse.Clase8JPAABM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    private ClientService clientService;
    @PostMapping
    public ResponseEntity<Object> postInvoice (@RequestBody RequestInvoice reqInvoice) {
        try {
            System.out.println(reqInvoice);
            //DTO Data transfer object
            InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
            return ResponseHandler.generateResponse(
                    "Invoice created successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Añadir getInvoice by id
    @GetMapping(path = "{invoice_id}")
    public ResponseEntity<Object> getInvoiceById (@PathVariable int invoice_id) {
        try {
            System.out.println(invoice_id);
            InvoiceWithDetailsDTO data = invoiceService.getInvoiceById(invoice_id);
            if(data != null) {
                return ResponseHandler.generateResponse(
                        "Get Invoice by Id succesful",
                        HttpStatus.OK,
                        data
                );
            }else{
                return ResponseHandler.generateResponse(
                        "Invoice doesnt exists",
                        HttpStatus.OK,
                        null
                );
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "/getInvoicesByClientId/{clientId}")
    public ResponseEntity<Object> getInvoicesByClientId (@PathVariable int clientId){
        try {
            List<InvoiceDTO> data = invoiceService.getInvoicesByClientId(clientId);
            if(data != null) {
                return ResponseHandler.generateResponse(
                        "Get Invoices by Client id successful",
                        HttpStatus.OK,
                        data
                );
            }else{
                return ResponseHandler.generateResponse(
                        "Doesnt exists Invoices by Client",
                        HttpStatus.OK,
                        null
                );
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}