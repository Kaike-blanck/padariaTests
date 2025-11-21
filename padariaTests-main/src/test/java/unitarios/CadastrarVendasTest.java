package unitarios;

import daos.VendaDao;
import entity.Venda;
import entity.VendaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CadastrarVendasTest {

    @Test
    public void deveCadastrarVendaCorreta(){
        //Arrange
        VendaDao dao = new VendaDao();
        Venda venda = new Venda("14799968794",50,"Pix");

        //Act
        dao.salvar(venda);

        //Assert
        Assertions.assertNotNull(venda);
        System.out.println("Venda realizada com sucesso");
    }
    @Test
    public void naoDeveCadastrarVendaComCpfInexistente() throws VendaInvalidaException {
        // Arrange
        VendaDao dao = new VendaDao();

        Venda venda = new Venda("00000000000", 50, "Pix");

        // Act e Assert
        VendaInvalidaException excecao = Assertions.assertThrows(VendaInvalidaException.class, () -> {
            dao.salvar(venda);
        });
        System.out.println(excecao.getMessage());
    }
    @Test
    public void naoDeveCadastrarVendaComTipoDePagamentoInexistente() throws VendaInvalidaException {
        // Arrange
        VendaDao dao = new VendaDao();

        Venda venda = new Venda("13113327903", 50, "");

        // Act e Assert
        VendaInvalidaException excecao =Assertions.assertThrows(VendaInvalidaException.class, () -> {
            dao.salvar(venda);

        });
        System.out.println(excecao.getMessage());
    }
    @Test
    public void naoDeveCadastrarVendaComValorInvalido() throws VendaInvalidaException {
        // Arrange
        VendaDao dao = new VendaDao();

        Venda venda = new Venda("13113327903", 0, "Pix");

        // Act e Assert
        VendaInvalidaException excecao =Assertions.assertThrows(VendaInvalidaException.class, () -> {
            dao.salvar(venda);

        });
        System.out.println(excecao.getMessage());
    }
}
