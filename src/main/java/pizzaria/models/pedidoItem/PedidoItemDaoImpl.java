/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.models.pedidoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pizzaria.models.sabor.Sabor;


/**
 * Author:  Eduardo e Christian
 * Created: 21/06/2023
 */
public class PedidoItemDaoImpl implements PedidoItemDao{
    private Connection con;

    public PedidoItemDaoImpl(Connection con) {
        this.con = con;
    }
    
    public List<PedidoItem> buscarTodosPedidosItens(String busca, int idCliente) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<PedidoItem> lista = new ArrayList<PedidoItem>();
        try {
            String sql  = "SELECT tpp.id"
                            +", s1.nome_sabor AS nome_sabor1"
                            +", s2.nome_sabor AS nome_sabor2"
                            +", tc.nome_cliente AS nome_cliente"
                            +", tpp.valor_pedido_item"
                            +", tfp.nome AS forma_pizza"
                            +", tp1.nome_tipo AS nome_tipo1"
                            +", tp2.nome_tipo as nome_tipo2"
                            +" FROM tb_pedido_pizza tpp"
                            +" INNER JOIN tb_sabor AS s1 ON (s1.id_sabor = tpp.id_sabor)"
                            +" INNER JOIN tb_sabor AS s2 ON (s2.id_sabor = tpp.id_sabor2)"
                            +" INNER JOIN tb_forma_pizza AS tfp ON (tfp.id = tpp.id_forma)"
                            +" INNER JOIN tb_tipopizza AS tp1 ON (tp1.id_tipo = s1.tipo_sabor)"
                            +" INNER JOIN tb_tipopizza AS tp2 ON (tp2.id_tipo = s2.tipo_sabor)"
                            +" INNER JOIN tb_pedido tp ON (tp.id_pedido = tpp.id_pedido)"
                            +" INNER JOIN tb_cliente tc ON (tp.id_cliente = tc.id_cliente)"
                            +" WHERE tc.id_cliente = "+idCliente+"";
                
           
           
            
            if(!busca.isEmpty()){
                sql = sql + " AND (tc.nome_cliente LIKE '%"+busca+"%' OR tc.sobrenome_cliente LIKE '%"+busca+"%'"
                          + " OR tc.telefone_cliente LIKE '%"+busca+"%' OR tc.endereco_cliente LIKE '%"+busca+"%'"
                          + " OR s2.nome_sabor LIKE '%"+busca+"%' OR tc.endereco_cliente LIKE '%"+busca+"%'"
                          + " OR s1.nome_sabor LIKE '%"+busca+"%' OR tp1.nome_tipo LIKE '%"+busca+"%'"
                          + " OR tp2.nome_tipo LIKE '%"+busca+"%' OR tfp.nome LIKE '%"+busca+"%')";
            } 
            
            sql = sql + " ORDER BY tc.id_cliente DESC";
        /*
        String sql = "SELECT tp.id_pedido, tc.nome_cliente, ti.nome AS nome_status,"
                        +" (SELECT SUM(tpp.valor_pedido_item) FROM tb_pedido_pizza tpp, tb_pedido tp"
            +" WHERE tpp.id_pedido = tp.id_pedido) AS total_pedido,"
                        +" (SELECT COUNT(id) FROM tb_pedido_pizza tpp, tb_pedido tp" 
            +" WHERE tpp.id_pedido = tp.id_pedido) AS qtd_itens"
                        +" FROM tb_pedido tp INNER JOIN tb_cliente tc ON (tp.id_cliente = tc.id_cliente)"
                        +" INNER JOIN tb_idstatus ti ON (ti.id = tp.id_status_pedido)";

            if(!busca.isEmpty()){
                sql = sql + " WHERE (tc.nome_cliente LIKE '%"+busca+"%' OR tc.sobrenome_cliente LIKE '%"+busca+"%'"
                          + " OR tc.telefone_cliente LIKE '%"+busca+"%' OR tc.endereco_cliente LIKE '%"+busca+"%'"
                          + " OR ti.nome LIKE '%"+busca+"%')";
            }
            sql = sql + " ORDER BY tc.id_cliente DESC";
            */
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                PedidoItem pi = new PedidoItem();
                Sabor s = new Sabor();
                Sabor s2 = new Sabor();
                s.setNome(rs.getString("nome_sabor1"));
                s.setNomeTipo(rs.getString("nome_tipo1"));
                s2.setNome(rs.getString("nome_sabor2"));
                s2.setNomeTipo(rs.getString("nome_tipo2"));
                pi.setId(rs.getInt("id"));
                pi.setSabor1(s);
                pi.setSabor2(s2);
                pi.setFormaNome(rs.getString("forma_pizza"));
                pi.setValor(rs.getDouble("valor_pedido_item"));
                lista.add(pi);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {
                }
            }
        }
    }
   
    public void AtualizarPedidoItem(PedidoItem pi) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("UPDATE tb_pedido_pizza SET id_pedido = ?, id_sabor = ?, id_sabor2 = ?, valor_pedido_item = ?, id_forma = ?"
                    + " WHERE id = ?");
            st.setInt(1, pi.getIdPedido());
            st.setInt(2, pi.getSabor1().getId());
            st.setInt(3, pi.getSabor2().getId());
            st.setDouble(4, pi.getValor());
            st.setInt(5, pi.getFormaId());
            st.setInt(6, pi.getId());
            int rowsAffected = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {
                }
            }
        }
    }
      
    public void removerPedidoItem(int id) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM tb_pedido_pizza WHERE id = ?");
            st.setString(1, Integer.toString(id));
            int rowsAffected = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {
                }
            }
        }
    }
     
    public void InserirPedidoItem(PedidoItem pi) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("INSERT INTO tb_pedido_pizza (id_pedido, id_sabor, id_sabor2, valor_pedido_item, id_forma) VALUES (?, ?, ?, ?, ?)");
            st.setInt(1, pi.getIdPedido());
            st.setInt(2, pi.getSabor1().getId());
            st.setInt(3, pi.getSabor2().getId());
            st.setDouble(4, pi.getValor());
            st.setDouble(5, pi.getFormaId());
            int rowsAffected = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {
               }
            }
        }
    }
}
