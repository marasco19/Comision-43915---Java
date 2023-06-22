package com.coderhouse.Clase8JPAABM.controller;

import com.coderhouse.Clase8JPAABM.middleware.ResponseHandler;

import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;


    //Create a Client
    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Client client) {
        try {
            System.out.println(client);
            if (!validarTiposDeDatos(client)) {
                Map<String, String> errores = new HashMap<>();
                errores.put("cliente", "Los tipos de datos no son válidos");
                return ResponseHandler.generateResponse(
                        "Bad Request",
                        HttpStatus.BAD_REQUEST,
                        errores
                );
            }
            Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client stored successfully",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
    //Get a Client
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Client clientFound = clientService.getClient(id);
            System.out.println("Cliente encontrado: " + clientFound);
            if(clientFound != null) {
                return ResponseHandler.generateResponse(
                        "Client get successfully",
                        HttpStatus.OK,
                        clientFound);
            }else{
                return ResponseHandler.generateResponse(
                        "Client dont exists",
                        HttpStatus.OK,
                        null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }

    }
    //Put a Client
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable int id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return ResponseHandler.generateResponse(
                    "Client updated successfully",
                    HttpStatus.OK,
                    updatedClient);
        } else {
            return ResponseHandler.generateResponse(
                    "Client doesnt exists",
                    HttpStatus.BAD_REQUEST,
                    "No existe Cliente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable int id) {
        Client deletedClient = clientService.deleteClient(id);
        if (deletedClient != null) {
            return ResponseHandler.generateResponse(
                    "Client deleted successfully",
                    HttpStatus.OK,
                    deletedClient);
        } else {
            return ResponseHandler.generateResponse(
                    "Client doesnt exists",
                    HttpStatus.BAD_REQUEST,
                    "No existe Producto");
        }
    }
    private boolean validarTiposDeDatos(Client client) {
        int document = client.getDocnumber();
        // Validar si es numérico
        String numeroDocumentoString = String.valueOf(document);
        if (!numeroDocumentoString.matches("\\d+")) {
            return false; // El campo NumeroDocumento no es numérico
        }
         if (client.getName() == null || client.getName().isEmpty()) {
             return false;
         }
         if (client.getLastname() == null || client.getLastname().isEmpty()) {
            return false;
         }

        // Si todas las validaciones pasan, retornar true
        return true;
    }

}