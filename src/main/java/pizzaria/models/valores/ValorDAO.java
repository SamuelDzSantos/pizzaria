package pizzaria.models.valores;

import java.util.List;
import java.util.Optional;

public interface ValorDAO {

    public void updateValor(int id, Double valor);

    public Optional<Valor> getValor(int id);

    public List<Valor> getValores();

}
