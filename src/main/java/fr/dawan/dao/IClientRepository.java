package fr.dawan.dao;

import fr.dawan.entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface IClientRepository
{
    void saveClient(Client client);
    void updateClient(Client client);
    List<Client> getAllClients();
    Client getClient(long code);
    void deleteClient(long code);
    List<Client> findCLientsByKey(String nom);

    static EntityManager createEntityManager()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BanqueJPA");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}
