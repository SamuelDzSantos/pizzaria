/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.models.sabor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pizzaria.models.cliente.ClienteObserver;

/**
 * Author:  Eduardo e Christian
 * Created: 21/06/2023
 */
public class SaborDaoImpl implements SaborDao {

    private final String inserir = "insert into tb_sabor(nome_sabor, tipo_sabor) values (?, ?)";
    private final String deletar = "delete from tb_sabor where id_sabor = ?";
    private final String select = "SELECT id_sabor, nome_sabor, tipo_sabor, tb_tipopizza.nome_tipo FROM tb_sabor "
    + "INNER JOIN tb_tipopizza ON (tb_tipopizza.id_tipo = tb_sabor.tipo_sabor)";
    private final String selectBusca = "  WHERE (nome_sabor LIKE ? OR tb_tipopizza.nome_tipo LIKE ? )";
    private final String selectId = "SELECT id_sabor, nome_sabor, tipo_sabor, tb_tipopizza.nome_tipo FROM tb_sabor \"\r\n" + //
            "    + \"INNER JOIN tb_tipopizza ON (tb_tipopizza.id_tipo = tb_sabor.tipo_sabor) WHERE id_sabor = ?";
    private Connection con;
    private final List<SaborObserver> observers = new ArrayList<>();

    public SaborDaoImpl(Connection con) {
        this.con = con;
    }

       public void subscribe(SaborObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(SaborObserver observer) {
        observers.remove(observer);
    }

    private void updateAllData(){
        List<Sabor> lista = new ArrayList<Sabor>();
        try (PreparedStatement st = con.prepareStatement(select); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Sabor sabor = new Sabor();
                sabor.setId(Integer.parseInt(rs.getString("id_sabor")));
                sabor.setNome(rs.getString("nome_sabor"));
                sabor.setNomeTipo(rs.getString("nome_tipo"));
                sabor.setTipo(Integer.parseInt(rs.getString("tipo_sabor")));
                lista.add(sabor);
            }
            for (SaborObserver observer : observers) {
                observer.updateSabor(lista);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private void updateAllData(List<Sabor> sabores){
    for (SaborObserver observer : observers) {
                observer.updateSabor(sabores);
            }
}

    @Override
    public void inserirSabor(Sabor s) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("insert into tb_sabor(nome_sabor, tipo_sabor) values (?, ?)");
            st.setString(1, s.getNome());
            st.setInt(2,s.getTipo());
            int rowsAffected = st.executeUpdate();
           this.updateAllData();
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

    public List<Sabor> buscarTodos() {
        List<Sabor> lista = new ArrayList<Sabor>();
        try (PreparedStatement st = con.prepareStatement(select); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Sabor sabor = new Sabor();
                sabor.setId(Integer.parseInt(rs.getString("id_sabor")));
                sabor.setNome(rs.getString("nome_sabor"));
                sabor.setNomeTipo(rs.getString("nome_tipo"));
                sabor.setTipo(Integer.parseInt(rs.getString("tipo_sabor")));
                lista.add(sabor);
            }
            this.updateAllData();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Sabor>();
        }
    }

    public void removerSabores(List<Integer> ids) {
        
        try (PreparedStatement st = con.prepareStatement(deletar)) {
            for(Integer id : ids){
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Deleted value! " + rowsAffected + "rows affected!");
            }
            this.updateAllData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Sabor> buscarSabor(Integer id){
        String sql = selectId;
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, id );
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Sabor s = new Sabor();
					s.setId(Integer.parseInt(rs.getString("id_sabor")));
					s.setNome(rs.getString("nome_sabor"));
					s.setNomeTipo(rs.getString("nome_tipo"));
					s.setTipo(Integer.parseInt(rs.getString("tipo_sabor")));
                    this.updateAllData();
                    return Optional.of(s);
                }
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    

    public List<Sabor> buscarTodos(String busca) {
        String sql = select + selectBusca;
        List<Sabor> lista = new ArrayList<Sabor>();
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, "%" + busca + "%");
            st.setString(2, "%" + busca + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Sabor s = new Sabor();
					s.setId(Integer.parseInt(rs.getString("id_sabor")));
					s.setNome(rs.getString("nome_sabor"));
					s.setNomeTipo(rs.getString("nome_tipo"));
					s.setTipo(Integer.parseInt(rs.getString("tipo_sabor")));
					lista.add(s);
                }
                this.updateAllData(lista);
                return lista;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Sabor>();
        }
    }
}

