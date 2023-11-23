package pizzaria.models.cliente;

import java.util.List;

public interface ClienteObserver {
    public void updateClientes(List<Cliente> clientes);

    public void addCliente(Cliente cliente);
}