
package pizzaria.models.pedidoItem;

import java.util.List;

public interface PedidoItemDao {
    public void InserirPedidoItem(PedidoItem pi);
    public List<PedidoItem> buscarTodosPedidosItens(String busca, int idCliente);
    public void AtualizarPedidoItem(PedidoItem pi);

}
