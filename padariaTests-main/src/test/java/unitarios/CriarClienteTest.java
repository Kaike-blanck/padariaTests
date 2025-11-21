package unitarios;

import entity.Cliente;
import entity.ClienteInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CriarClienteTest {

    @Test
    public void deveCriarUsuarioValido(){
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14899912345";
        String telefone = "47999999999";
        int pontos = 0;

        //Act
        Cliente cliente = new Cliente(id,nome,cpf,telefone,pontos);

        //Assert
        Assertions.assertNotNull(cliente);
    }
    @Test
    public void deveFalharCriarUsuarioComNomeInvalido() throws ClienteInvalidoException {
        //Arrange
        int id = 1;
        String nome = "";
        String cpf = "14899912345";
        String telefone = "47999999999";
        int pontos = 0;

        // Act e Assert
        ClienteInvalidoException excecao = Assertions.assertThrows(ClienteInvalidoException.class, () -> {

            new Cliente(id, nome, cpf, telefone, pontos);
        });
        System.out.println(excecao.getMessage());
    }

    @Test
    public void deveFalharCriarUsuarioComCpfInvalido() throws ClienteInvalidoException {
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14899912";
        String telefone = "47999999999";
        int pontos = 0;

        // Act e Assert
        ClienteInvalidoException excecao = Assertions.assertThrows(ClienteInvalidoException.class, () -> {

            new Cliente(id, nome, cpf, telefone, pontos);
        });
        System.out.println(excecao.getMessage());
    }

    @Test
    public void deveFalharCriarUsuarioComTelefoneInvalido() throws ClienteInvalidoException {
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14899912345";
        String telefone = "47999";
        int pontos = 0;

        // Act e Assert
        ClienteInvalidoException excecao = Assertions.assertThrows(ClienteInvalidoException.class, () -> {

            new Cliente(id, nome, cpf, telefone, pontos);
        });
        System.out.println(excecao.getMessage());
    }

    @Test
    public void deveGerarSenhaCorreta() {
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14875912345";
        String telefone = "47999999999";
        int pontos = 0;

        String senhaCorreta = "And148";

        //Act
        Cliente cliente = new Cliente(id,nome,cpf,telefone,pontos);

        Assertions.assertEquals(cliente.getSenha(), senhaCorreta,"A senha deve conter os 3 primeiros caracteres do nome do cliente, e após isso os 3 primeiros dígitos do cpf");

    }

    @Test
    public void deveCriarUsuarioComZeroPontos() {
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14875912345";
        String telefone = "47999999999";
        int pontos = 0;

        String senhaCorreta = "And148";

        //Act
        Cliente cliente = new Cliente(id,nome,cpf,telefone,pontos);

        //Assert
        Assertions.assertEquals(cliente.getTotPontosAcumulados(), pontos, "O usuário foi criado com 0 pontos");

    }

}
