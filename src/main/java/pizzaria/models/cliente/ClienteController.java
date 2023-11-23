package pizzaria.models.cliente;

import java.util.Optional;

import javax.swing.JTable;

import pizzaria.main.MainView;
import pizzaria.models.cliente.view.ClienteFormView;

public class ClienteController {

    private MainView mainView;
    private ClienteDao clienteDao;

    public void initController(MainView mainView, ClienteDao clienteDao) {
        this.mainView = mainView;
        this.clienteDao = clienteDao;
    }

    public ClienteController() {
    }

    public void editarCliente(JTable tabela) {
        int rowIndex = tabela.getSelectedRow();
        int id = Integer.parseInt(tabela.getValueAt(rowIndex, 0).toString());
        Optional<Cliente> cliente = this.clienteDao.buscarPorId(id);
        if (cliente.isPresent()) {
            new ClienteFormView(clienteDao, this, cliente.get());
        }
    }

    public void removerCliente(Integer id) {
        this.clienteDao.remover(id);
    }

    public void buscarClientes(String busca) {
        if (busca.isBlank() || busca.isEmpty() || busca.equals(" ")) {
            this.clienteDao.buscarTodos();
        } else {
            this.clienteDao.buscarTodos(busca);
        }
    }

    public void addCliente(String nome, String sobrenome, String telefone,
            String endereco) {

    }

    public void updateCliente(Integer id, String nome, String sobrenome, String telefone,
            String endereco) {

    }

}
