/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.models.sabor;

import java.util.List;
import java.util.Optional;


/**
 * Author:  Eduardo e Christian
 * Created: 21/06/2023
 */
public interface SaborDao {
    public void inserirSabor(Sabor s);
    public void removerSabores(List<Integer> ids);
    public List<Sabor> buscarTodos(String busca);
    public List<Sabor> buscarTodos();
    public Optional<Sabor> buscarSabor(Integer id);
    public void subscribe(SaborObserver observer);
    public void unsubscribe(SaborObserver observer);
}
