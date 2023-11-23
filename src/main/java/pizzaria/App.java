package pizzaria;

import java.sql.Connection;

import pizzaria.main.MainView;
import pizzaria.models.cliente.ClienteController;
import pizzaria.models.cliente.ClienteDao;
import pizzaria.models.cliente.ClienteDaoImpl;
import pizzaria.models.pedido.Pedido;
import pizzaria.models.pedido.PedidoController;
import pizzaria.models.sabor.SaborController;
import pizzaria.models.sabor.SaborDao;
import pizzaria.models.sabor.SaborDaoImpl;
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
        SaborDao saborDao = new SaborDaoImpl(con);
        SaborController saborController = new SaborController();
        PedidoController pedidoController = new PedidoController();
        new MainView(clienteDao, clienteController, valorController, valorDAO,saborController,saborDao,pedidoController);
    }
}
