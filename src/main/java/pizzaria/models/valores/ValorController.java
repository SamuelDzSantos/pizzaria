package pizzaria.models.valores;

import java.util.List;

public class ValorController {

    private ValorDAO valorDAO;

    public ValorController() {

    }

    public void initValorController(ValorDAO valorDAO) {
        this.valorDAO = valorDAO;
    }

    public void atualizarValores(List<Double> valoresDouble) {
        for (int x = 0; x < 3; x++) {
            this.valorDAO.updateValor(x + 1, valoresDouble.get(x));
        }
    }



}
