package com.example.codoacodofinal.service;

import com.example.codoacodofinal.dao.ClientDao;
import com.example.codoacodofinal.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> listClients() {
        return (List<Client>)  clientDao.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        clientDao.delete(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findClients(Client client) {
        return clientDao.findById(client.getIdClient()).orElse(null);
    }
}
