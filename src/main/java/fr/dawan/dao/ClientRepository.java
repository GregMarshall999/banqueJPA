package fr.dawan.dao;

import fr.dawan.entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientRepository implements IClientRepository
{
    @Override
    public void saveClient(Client client)
    {
        EntityManager entityManager = IClientRepository.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();
            entityManager.persist(client);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateClient(Client client) {
        if(client.getCode()>0)
        {
            EntityManager manager = IClientRepository.createEntityManager();
            EntityTransaction transaction = manager.getTransaction();

            try
            {
                transaction.begin();
                manager.merge(client);
                transaction.commit();
            } catch (Exception e)
            {
                transaction.rollback();
            } finally {
                manager.close();
            }
        }
    }

    @Override
    public List<Client> getAllClients()
    {
        List<Client> clients;
        EntityManager manager = IClientRepository.createEntityManager();

        String sql = "SELECT entity FROM " + Client.class.getName() + " entity";
        TypedQuery<Client> query = manager.createQuery(sql, Client.class);
        clients = query.getResultList();

        return clients;
    }

    @Override
    public Client getClient(long code)
    {
        EntityManager manager = IClientRepository.createEntityManager();
        Client client = null;

        try
        {
            client = manager.find(Client.class, code);
        } catch (Exception e)
        {
        } finally {
            manager.close();
        }

        return client;
    }

    @Override
    public void deleteClient(long code)
    {
        EntityManager manager = IClientRepository.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try
        {
            transaction.begin();
            Client client = getClient(code);
            manager.remove(client);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Client> findCLientsByKey(String nom)
    {
        List<Client> clients;
        EntityManager manager = IClientRepository.createEntityManager();

        String sql = "SELECT * FROM Client WHERE cl_name LIKE '%"+nom+"%'";
        Query query = manager.createNativeQuery(sql, Client.class);
        clients = query.getResultList();
        manager.close();
        return clients;
    }
}
