package pizzaria;

import java.sql.Connection;

import pizzaria.main.MainView;
import pizzaria.models.cliente.ClienteController;
import pizzaria.models.cliente.ClienteDao;
import pizzaria.models.cliente.ClienteDaoImpl;
import pizzaria.services.ConnectionFactory;

public class App {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
        ClienteDao clienteDao = new ClienteDaoImpl(con);
        ClienteController clienteController = new ClienteController();
        new MainView(clienteDao, clienteController);
    }
}
