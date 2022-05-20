package fr.dawan.dao;

import fr.dawan.entities.Client;

import java.util.List;

public interface IClientRepository
{
    void saveClient(Client client);
    void updateClient(Client client);
    List<Client> getAllClients();
    Client getClient(long code);
    void deleteClient(long code);
    List<Client> findCLientsByKey(String nom);
}
