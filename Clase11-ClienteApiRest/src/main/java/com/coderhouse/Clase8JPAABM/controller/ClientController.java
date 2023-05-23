package com.coderhouse.Clase8JPAABM.controller;

import com.coderhouse.Clase8JPAABM.middleware.ResponseHandler;

import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.model.ClientDTO;
import com.coderhouse.Clase8JPAABM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                //Calculo la edad
                int edad = clientService.calcularEdad(clientFound.getBirthday());
                System.out.println("Calculo de Edad: " + edad);
                //Seteo el nuevo clietneDTO
                ClientDTO clienteDTO = new ClientDTO(clientFound.getName(), clientFound.getLastname(), edad);
                System.out.println("Nombre: " + clienteDTO.getNombre());
                System.out.println("Apellido: " + clienteDTO.getApellido());
                System.out.println("Años: " + clienteDTO.getAnios());

                return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    clienteDTO);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
        return null;
    }

}