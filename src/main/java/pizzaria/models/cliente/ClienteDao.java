/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.models.cliente;

import java.util.List;
import java.util.Optional;

/**
 * Author: Eduardo e Christian
 * Created: 21/06/2023
 */
public interface ClienteDao {

    public void inserir(Cliente c);

    public void atualizar(Cliente c);

    public void remover(int id);

    public void remover(List<Integer> ids);

    public List<Cliente> buscarTodos();

    public List<Cliente> buscarTodos(String busca);

    public List<Cliente> buscarTodos(Cliente exemplo);

    public Optional<Cliente> buscarPorId(int id);

}
