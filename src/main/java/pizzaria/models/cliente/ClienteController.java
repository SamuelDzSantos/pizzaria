package pizzaria.models.cliente;

import java.util.List;
import java.util.Optional;

import javax.swing.JTable;

import pizzaria.main.MainView;
import pizzaria.models.cliente.view.ClienteFormView;
import pizzaria.models.pedido.view.PedidoFormView;
import pizzaria.models.valores.ValorController;
import pizzaria.models.valores.ValorDAO;

public class ClienteController {

    private MainView mainView;
    private ClienteDao clienteDao;
    private ValorController valorController;
    private ValorDAO valorDAO;

    public void initController(MainView mainView, ClienteDao clienteDao,ValorController valorController,ValorDAO valorDAO) {
        this.mainView = mainView;
        this.clienteDao = clienteDao;
        this.valorController= valorController;
        this.valorDAO = valorDAO;
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

    public void removerClientes(List<Integer> ids) {
        this.clienteDao.remover(ids);
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
        Cliente cliente = new Cliente(0, nome, sobrenome, telefone, endereco);
        this.clienteDao.inserir(cliente);
    }

    public void updateCliente(Integer id, String nome, String sobrenome, String telefone,
            String endereco) {
        Cliente cliente = new Cliente(id, nome, sobrenome, telefone, endereco);
        this.clienteDao.atualizar(cliente);
    }

    public void addPedido(JTable tabela) {
        int rowIndex = tabela.getSelectedRow();
        int id = Integer.parseInt(tabela.getValueAt(rowIndex, 0).toString());
        Optional<Cliente> cliente = this.clienteDao.buscarPorId(id);
        if (cliente.isPresent()) {
            PedidoFormView telaPedido = new PedidoFormView(cliente.get(),this.valorController,this.valorDAO);
            telaPedido.setVisible(true);
        }
    }

}
