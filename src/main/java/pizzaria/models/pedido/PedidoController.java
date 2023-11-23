package pizzaria.models.pedido;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import pizzaria.models.pedido.Pedido;
import pizzaria.models.pedidoItem.PedidoItem;
import pizzaria.models.pedidoItem.PedidoItemDao;
import pizzaria.models.pizza.FormaPizza;
import pizzaria.models.sabor.Sabor;
import pizzaria.models.sabor.SaborDao;
import pizzaria.models.valores.ValorDAO;




public class PedidoController {

    private  SaborDao saborDAO;
    private  ValorDAO valorDAO;
    private  PedidoItemDao pedidoItemDao;
    private  PedidoDao pedidoDao;

    public PedidoController(){

    }

    public void initController(SaborDao saborDAO,ValorDAO valorDAO,PedidoItemDao pedidoItemDao,PedidoDao pedidoDao){
        this.saborDAO = saborDAO;
        this.valorDAO = valorDAO;
        this.pedidoItemDao = pedidoItemDao;
        this.pedidoDao =pedidoDao;
    }

        private Double calculaValorItemPedido(PedidoItem item){
        if(item.getSabor1().getTipo() == item.getSabor2().getTipo()){
            
            Double valor = this.valorDAO.getValor(item.getSabor1().getId()).get().getPreco();
            return valor * item.getArea();
        }else{
            Double valor1 = this.valorDAO.getValor(item.getSabor1().getId()).get().getPreco();
            Double valor2 = this.valorDAO.getValor(item.getSabor2().getId()).get().getPreco();
            return ((valor1+valor2)/2)*item.getArea();
        }
    }

    public void adicionarPedido(int idCliente,FormaPizza forma,Double medida,int indexSabor1,int indexSabor2){
        Pedido pedido = new Pedido();
        pedido.setStatus(1);
        pedido.setIdCliente(idCliente);
        pedidoDao.inserir(pedido);
        /*
        PedidoItem itemPedido = new PedidoItem();
        forma.setMedida(medida);
        itemPedido.setMedida(forma.getMedida());
        itemPedido.setArea(forma.getArea());
        itemPedido.setForma(forma);
        Optional<Sabor> sabor1 = this.saborDAO.buscarSabor(indexSabor1);
        Optional<Sabor> sabor2 = this.saborDAO.buscarSabor(indexSabor2);
        if(sabor1.isEmpty() || sabor2.isEmpty()){
            return;
        }
        itemPedido.setSabor1(sabor1.get());
        itemPedido.setSabor2(sabor2.get());
        itemPedido.setValor(calculaValorItemPedido(itemPedido));
        pedidoItemDao.InserirPedidoItem(itemPedido);
             */

    }
        
    
//  //  pd.setIdCliente(this.id_cliente);
    //pd.setStatus(1);
  //  PedidoDao pDao = new PedidoDaoImpl(con);
   // pDao.InserirPedido(pd);
}
