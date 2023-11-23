/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria.models.sabor;

import pizzaria.models.pedido.view.PedidoFormView;

/**
 *
 * @author chris
 */
public class SaborController {
    private PedidoFormView pedidoFormView;
    private SaborDao saborDao;
    
    public void initController(PedidoFormView pedidoFormView, SaborDao saborDao) {
        this.pedidoFormView = pedidoFormView;
        this.saborDao = saborDao;
    }
}
