package org.brazil.generation.gfood.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

        List<Produto> findByNOme(String nome);

        List<Produto> findByPrecoLessThan(BigDecimal preco);

        List<Produto> findByPrecoGreaterThan(BigDecimal preco);

        List<Produto> findByDescricaoBetween(BigDecimal preco);
    }
}
