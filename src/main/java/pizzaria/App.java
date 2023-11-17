package pizzaria;

import java.sql.Connection;

import pizzaria.models.cliente.Cliente;
import pizzaria.models.cliente.ClienteDao;
import pizzaria.models.cliente.ClienteDaoImpl;
import pizzaria.services.ConnectionFactory;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection con = ConnectionFactory.getConnection();
        ClienteDao dao = new ClienteDaoImpl(con);
        Cliente c = new Cliente(10, "nome1", "sobrenome2", "123451", "Rua jose jose!");
        dao.inserir(c);
    }
}
