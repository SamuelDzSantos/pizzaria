/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.models.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Eduardo e Christian
 * Created: 21/06/2023
 */
public class ClienteDaoImpl implements ClienteDao {

    private final String inserir = "INSERT INTO tb_cliente (nome_cliente, sobrenome_cliente, telefone_cliente, endereco_cliente) VALUES (?, ?, ?, ?)";
    private final String atualizar = "UPDATE tb_cliente SET nome_cliente = ?, sobrenome_cliente = ?, telefone_cliente = ?, endereco_cliente = ?"
            + " WHERE id_cliente = ?";
    private final String deletar = "DELETE FROM tb_cliente WHERE id_cliente = ?";
    private final String select = "SELECT tb_cliente.id_cliente, nome_cliente, sobrenome_cliente, telefone_cliente, endereco_cliente FROM tb_cliente"
            + " LEFT JOIN tb_pedido ON (tb_pedido.id_cliente = tb_cliente.id_cliente)"
            + " LEFT JOIN tb_idstatus ON (tb_idstatus.id = tb_pedido.id_status_pedido)";
    private final String selectBusca = " WHERE (nome_cliente LIKE  ?  OR sobrenome_cliente LIKE  ?  OR " +
            "telefone_cliente LIKE  ?   OR endereco_cliente LIKE  ?  ) ORDER BY tb_cliente.id_cliente DESC";
    private final String selectPorId = "SELECT * FROM tb_cliente WHERE tb_cliente.id_cliente = ?";

    private final List<ClienteObserver> observers = new ArrayList<>();

    private Connection con;

    public ClienteDaoImpl(Connection con) {
        this.con = con;
    }

    public void subscribe(ClienteObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(ClienteObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void inserir(Cliente c) {
        try (PreparedStatement st = con.prepareStatement(inserir, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, c.getNome());
            st.setString(2, c.getSobrenome());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEndereco());
            int rowsAffected = st.executeUpdate();
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {

                for (ClienteObserver observer : observers) {
                    if (generatedKeys.next()) {
                        c.setId(generatedKeys.getInt(1));
                    }
                    observer.addCliente(c);
                }
                if (rowsAffected == 1) {
                    System.out.println("Inserted value! " + rowsAffected + "rows affected!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Cliente c) {

        try (PreparedStatement st = con.prepareStatement(atualizar)) {
            st.setString(1, c.getNome());
            st.setString(2, c.getSobrenome());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEndereco());
            st.setInt(5, c.getId());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Updated value! " + rowsAffected + "rows affected!");
            }
            List<Cliente> clientes = this.buscarTodos();
            for (ClienteObserver observer : observers) {
                observer.updateClientes(clientes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        System.out.println(id);
        try (PreparedStatement st = con.prepareStatement(deletar)) {
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Deleted value! " + rowsAffected + "rows affected!");
            }
            List<Cliente> clientes = this.buscarTodos();
            for (ClienteObserver observer : this.observers) {
                observer.updateClientes(clientes);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(List<Integer> ids) {
        try (PreparedStatement st = con.prepareStatement(deletar)) {
            int rowsAffected = 0;
            for (Integer id : ids) {
                st.setInt(1, id);
                rowsAffected += st.executeUpdate();
            }
            if (rowsAffected >= 1) {
                System.out.println("Deleted value! " + rowsAffected + "rows affected!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Cliente> clientes = this.buscarTodos();
        for (ClienteObserver observer : this.observers) {
            observer.updateClientes(clientes);
        }
    }

    // heh3
    @Override
    public List<Cliente> buscarTodos(String busca) {
        String sql = select + selectBusca;
        List<Cliente> lista = new ArrayList<Cliente>();
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, "%" + busca + "%");
            st.setString(2, "%" + busca + "%");
            st.setString(3, "%" + busca + "%");
            st.setString(4, "%" + busca + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(Integer.parseInt(rs.getString("id_cliente")));
                    c.setNome(rs.getString("nome_cliente"));
                    c.setSobrenome(rs.getString("sobrenome_cliente"));
                    c.setTelefone(rs.getString("telefone_cliente"));
                    c.setEndereco(rs.getString("endereco_cliente"));
                    lista.add(c);
                }
                for (ClienteObserver observer : observers) {
                    observer.updateClientes(lista);
                }
                return lista;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Cliente>();
        }
    }

    @Override
    public List<Cliente> buscarTodos(Cliente example) {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (PreparedStatement st = con.prepareStatement(select); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(Integer.parseInt(rs.getString("id_cliente")));
                c.setNome(rs.getString("nome_cliente"));
                c.setSobrenome(rs.getString("sobrenome_cliente"));
                c.setTelefone(rs.getString("telefone_cliente"));
                c.setEndereco(rs.getString("endereco_cliente"));
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Cliente>();
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (PreparedStatement st = con.prepareStatement(select); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(Integer.parseInt(rs.getString("id_cliente")));
                c.setNome(rs.getString("nome_cliente"));
                c.setSobrenome(rs.getString("sobrenome_cliente"));
                c.setTelefone(rs.getString("telefone_cliente"));
                c.setEndereco(rs.getString("endereco_cliente"));
                lista.add(c);
            }
            for (ClienteObserver observer : observers) {
                observer.updateClientes(lista);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Cliente>();
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(int id) {
        try (PreparedStatement st = con.prepareStatement(selectPorId);) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(Integer.parseInt(rs.getString("id_cliente")));
                    c.setNome(rs.getString("nome_cliente"));
                    c.setSobrenome(rs.getString("sobrenome_cliente"));
                    c.setTelefone(rs.getString("telefone_cliente"));
                    c.setEndereco(rs.getString("endereco_cliente"));
                    return Optional.of(c);
                }
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}