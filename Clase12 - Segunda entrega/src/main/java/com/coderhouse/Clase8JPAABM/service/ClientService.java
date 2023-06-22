package com.coderhouse.Clase8JPAABM.service;

import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.model.Product;
import com.coderhouse.Clase8JPAABM.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    public Client getClient(int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);
        if(cliente.isEmpty()){
            return null;
        } else {
            return cliente.get();
        }
    }
    public Client updateClient(int id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(client.getName());
            existingClient.setLastname(client.getLastname());
            existingClient.setDocnumber(client.getDocnumber());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }
    public Client deleteClient(int id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            clientRepository.delete(client);
            return client;
        } else {
            return null;
        }
    }

}