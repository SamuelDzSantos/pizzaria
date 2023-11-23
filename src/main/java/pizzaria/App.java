package pizzaria;

import java.sql.Connection;

import pizzaria.main.MainView;
import pizzaria.models.cliente.ClienteController;
import pizzaria.models.cliente.ClienteDao;
import pizzaria.models.cliente.ClienteDaoImpl;
import pizzaria.models.valores.ValorController;
import pizzaria.models.valores.ValorDAO;
import pizzaria.models.valores.ValorDAOImpl;
import pizzaria.services.ConnectionFactory;

public class App {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
        ClienteDao clienteDao = new ClienteDaoImpl(con);
        ClienteController clienteController = new ClienteController();
        ValorController valorController = new ValorController();
        ValorDAO valorDAO = new ValorDAOImpl(con);
        new MainView(clienteDao, clienteController, valorController, valorDAO);
    }
}
