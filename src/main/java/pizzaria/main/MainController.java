package pizzaria.main;

import pizzaria.models.cliente.ClienteDao;

public class MainController {
    private final MainView view;
    private final ClienteDao clienteDao;

    MainController(MainView view, ClienteDao clienteDao) {
        this.view = view;
        this.clienteDao = clienteDao;
    }

    public void buscarClientes() {
        clienteDao.buscarTodos();
    }
}
