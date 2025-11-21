/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unitarios;

import entity.Produto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class DeletarProdutoTest {
    
    @Test
    public void deveDeletarProduto(){
        
        //arrange
        int id = 1;
        String nome = "Pão Francês";
        double preco = 5.0;
        String tipo = "Paês";
        int qtEstoque = 20;

        List<Produto> lista = new ArrayList<Produto>();

        //act
        Produto produto = new Produto(id, nome, preco, tipo, qtEstoque);

        lista.add(produto);

        lista.removeIf(p -> p.getId() == 1);

        //assert
        Assertions.assertEquals(0, lista.size());
    }
    
    @Test
    public void deveValidarDeletarProdutoInvalido(){
        //arrange
        int id = 1;
        String nome = "Pão Francês";
        double preco = 5.0;
        String tipo = "Paês";
        int qtEstoque = 20;

        List<Produto> lista = new ArrayList<Produto>();

        //act
        Produto produto = new Produto(id, nome, preco, tipo, qtEstoque);

        lista.add(produto);

        boolean deletado = lista.removeIf(p -> p.getId() == 0); 
        
        //assert
        Assertions.assertFalse(deletado);
        Assertions.assertEquals(1, lista.size(), "Não foi possível deletar o produto!");
    }
}
