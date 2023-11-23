package pizzaria.models.cliente;

import java.util.List;
import java.util.Optional;


public interface ClienteDao {

    public void inserir(Cliente c);

    public void atualizar(Cliente c);

    public void remover(int id);

    public void remover(List<Integer> ids);

    public List<Cliente> buscarTodos();

    public List<Cliente> buscarTodos(String busca);

    public List<Cliente> buscarTodos(Cliente exemplo);

    public Optional<Cliente> buscarPorId(int id);

    public void subscribe(ClienteObserver observer);

    public void unsubscribe(ClienteObserver observer);

}
