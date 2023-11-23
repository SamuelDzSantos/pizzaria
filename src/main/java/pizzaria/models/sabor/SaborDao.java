/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.models.sabor;

import java.util.List;

/**
 * Author:  Eduardo e Christian
 * Created: 21/06/2023
 */
public interface SaborDao {
    public void inserirSabor(Sabor s);
    public void removerSabor(int id);
    public List<Sabor> buscarTodos(String busca);
}
