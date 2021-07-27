package com.example.codoacodofinal.service;

import com.example.codoacodofinal.domain.Client;

import java.util.List;

public interface ClientService {

    public List<Client> listClients();

    public void save(Client client);

    public void delete(Client client);

    public Client findClients(Client client);
}
