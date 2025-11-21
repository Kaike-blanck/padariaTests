package unitarios;

import entity.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsultarPontosTest {

    @Test
    public void deveMostrarQuantidadeDePontosClienteComPontos(){
        //Arrange
        Cliente cliente = new Cliente(15,"Andrei Effting","14899966687","48996557788",10);

        //Act
        int pontos = cliente.getTotPontosAcumulados();

        //Assert
        Assertions.assertEquals(10, pontos);

    }
    @Test
    public void deveRetornarQuantidadeDePontosClienteSemPontos(){
        //Arrange
        Cliente cliente = new Cliente(15,"Andrei Effting","14899966687","48996557788",0);

        //Act
        int pontos = cliente.getTotPontosAcumulados();

        //Assert
        Assertions.assertEquals(0, pontos);
    }
}
