/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria.models.sabor;

import java.util.List;

import pizzaria.models.pedido.view.PedidoFormView;

/**
 *
 * @author chris
 */
public class SaborController {
    private SaborDao saborDao;
    
    public void initController(SaborDao saborDao) {
        this.saborDao = saborDao;
    }



    public void buscarSabor(String sabor){
        if(sabor.isEmpty()){
            this.saborDao.buscarTodos();
        }else{
            this.saborDao.buscarTodos(sabor);
        }
    }

    public List<Sabor> buscarSabores(){
        return this.saborDao.buscarTodos();
    }

    public void removerSabor(List<Integer> ids){  
        this.saborDao.removerSabores(ids);
    }

    public void salvarSabor(String nome, String tipo){
        Sabor sabor = new Sabor();
        sabor.setNome(nome);
        sabor.setNomeTipo(tipo);
        sabor.setTipo(this.getTipo(tipo));
        this.saborDao.inserirSabor(sabor);
    }

    private int getTipo(String tipo){
        if(tipo == "Simples"){
            return 1;
        }
        if(tipo == "Especial"){
            return 2;
        }
        if(tipo == "Premium"){
            return 3;
        }
        return 1;
    }
}
