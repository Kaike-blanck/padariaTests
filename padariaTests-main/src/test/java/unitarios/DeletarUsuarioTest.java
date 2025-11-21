/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unitarios;

import entity.Cliente;
import entity.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kaike
 */
public class DeletarUsuarioTest {
    
    
   @Test
   public void deveDeletarUsuario(){
       
       //arrange
       List<Cliente> lista = new ArrayList<>();
       
       int id = 1;
       String nome = "Andrei";
       String cpf = "14899912345";
       String telefone = "47999999999";
       int pontos = 0;
       
       //act
       Cliente cliente = new Cliente (id, nome, cpf, telefone, pontos);
       
       lista.add(cliente);
       
       lista.removeIf( c -> c.getCpf().equals("14899912345"));
       
       //assert
       Assertions.assertEquals(0, lista.size());
    }
   
   public void deveValidarDeletarUsuarioInvalido() {
       
        //arrange
       List<Cliente> lista = new ArrayList<>();
       
       int id = 1;
       String nome = "Andrei";
       String cpf = "14899912345";
       String telefone = "47999999999";
       int pontos = 0;
       
       //act
       Cliente cliente = new Cliente (id, nome, cpf, telefone, pontos);
       
       lista.add(cliente);
       
       boolean deletado = lista.removeIf(c -> c.getCpf().equals("11122233344"));
       
       //assert
       Assertions.assertFalse(deletado);
       Assertions.assertEquals(1, lista.size(), "Nenhum usuário com esse CPF encontrado!");
   }
}
