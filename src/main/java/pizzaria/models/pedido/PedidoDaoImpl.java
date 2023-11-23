package pizzaria.models.pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidoDaoImpl implements PedidoDao {
    
    private final Connection con;

    public PedidoDaoImpl(Connection con){
        this.con = con;
    }

    private String insert = "INSERT INTO tb_pedido(id_status_pedido,id_cliente) VALUES (?,?)";


    public void inserir(Pedido pedido){
        try(PreparedStatement st = con.prepareStatement(insert)){
            st.setInt(1,pedido.getStatus());
            st.setInt(2,pedido.getIdCliente());
            st.executeQuery();
        }catch(Exception e){

        }
    }

}
