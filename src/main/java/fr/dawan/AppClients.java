package fr.dawan;

import fr.dawan.dao.ClientRepository;
import fr.dawan.entities.Client;

public class AppClients
{
    public static void main(String[] args)
    {
        ClientRepository repository = new ClientRepository();

        Client client = new Client();
        client.setNom("Doe");
        client.setEmail("john.doe@test.com");

        repository.saveClient(client);
    }
}
