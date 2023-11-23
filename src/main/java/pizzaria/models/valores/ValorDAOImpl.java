package pizzaria.models.valores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValorDAOImpl implements ValorDAO {

    private final String update = "UPDATE tb_tipopizza SET preco_tipo=? WHERE id_tipo = ?";
    private final String select = "SELECT * FROM tb_tipopizza";
    private final String selectId = "SELECT * FROM tb_tipopizza WHERE id_tipo=?";
    private final Connection con;
    private final List<ValorObserver> observers = new ArrayList<>();

    public ValorDAOImpl(Connection con) {
        this.con = con;
    }

    public void subscribe(ValorObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(ValorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void updateValor(int id, Double valor) {
        try (PreparedStatement st = con.prepareStatement(update)) {
            st.setDouble(1, valor);
            st.setInt(2, id);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected + "rows affected!");
            for (ValorObserver observer : observers) {
                observer.updateValores(this.getValores());
            }
        } catch (Exception e) {

        }
    }

    @Override
    public Optional<Valor> getValor(int id) {
        try (PreparedStatement st = con.prepareStatement(selectId)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Valor valor = new Valor();
                    valor.setId(rs.getInt("id_tipo"));
                    valor.setNome(rs.getString("nome_tipo"));
                    valor.setPreco(rs.getDouble("preco_tipo"));
                    return Optional.of(valor);
                }
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Valor> getValores() {
        try (PreparedStatement st = con.prepareStatement(select); ResultSet rs = st.executeQuery()) {
            List<Valor> valores = new ArrayList<>();
            while (rs.next()) {
                Valor valor = new Valor();
                valor.setId(rs.getInt("id_tipo"));
                valor.setNome(rs.getString("nome_tipo"));
                valor.setPreco(rs.getDouble("preco_tipo"));
                valores.add(valor);
            }
            return valores;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
