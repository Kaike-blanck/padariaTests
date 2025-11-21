package unitarios;

import daos.ProdutoDao;
import entity.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlterarProdutoTest {

    @Test
    public void deveAlterarDadosProduto(){
        //Arrange
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.consultarPeloId(8);
        Produto novoProduto = new Produto(produto.getId(), "Pão francês", 5.99,"Pão",40);

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());


        //Assert
        Assertions.assertEquals(produtoAtualizado.getNome(), novoProduto.getNome());
        System.out.println("Informações do produto alteradas com sucesso");
    }

    @Test
     public void deveAlterarNomeProduto(){
        //Arrange
        ProdutoDao dao = new ProdutoDao();

        Produto produto = dao.consultarPeloId(8);
        Produto novoProduto = new Produto(produto.getId(), "Pão Americano", 5.99,"Pão",40);

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());
        //Assert

        Assertions.assertEquals(produtoAtualizado.getNome(), novoProduto.getNome());
        System.out.println("O nome do produto foi alterado com sucesso");
    }
    @Test
    public void deveAlterarPrecoProduto(){
        //Arrange
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.consultarPeloId(8);
        Produto novoProduto = new Produto(produto.getId(), "Pão Americano", 7.99,"Pão",40);

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());
        //Assert

        Assertions.assertEquals(produtoAtualizado.getPreco(), novoProduto.getPreco());
        System.out.println("O valor do produto foi alterado com sucesso");
    }
    @Test
    public void deveAlterarQuantidadeProduto(){
        //Arrange
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.consultarPeloId(8);
        Produto novoProduto = new Produto(produto.getId(), "Pão Americano", 7.99,"Pão",65);

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());
        //Assert

        Assertions.assertEquals(produtoAtualizado.getQuantidadeEstoque(), novoProduto.getQuantidadeEstoque());
        System.out.println("A quantidade do produto foi alterado com sucesso");
    }
}
