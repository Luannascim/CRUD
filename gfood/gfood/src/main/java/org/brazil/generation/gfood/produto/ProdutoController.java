package org.brazil.generation.gfood.produto;

import org.brazil.generation.gfood.cliente.ClienteRepository;
import org.brazil.generation.gfood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produto")
    public Produto save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Optional<Produto> findByid(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }


    @GetMapping("/produto/nome/{nome}")
    public Produto findByNome(@PathVariable String nome) {
        return (Produto) produtoRepository.findByNome(nome);
    }

    @GetMapping("/produto/menos/{preco}")
    public Produto findByPrecoLessThan(@PathVariable BigDecimal preco){
        return (Produto) produtoRepository.findByPrecoLessThan(preco);
    }

    @GetMapping("/produto/mais/{preco}")
    public  Produto findByPrecoGreaterThan(@PathVariable BigDecimal preco){
        return (Produto) produtoRepository.findByPrecoGreaterThan(preco);
    }

   

    @PutMapping("/produto/id")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) throws ResourceNotFoundException {
        return produtoRepository.findById(id).map(updatedProduto -> {
            updatedProduto.setNome(produto.getNome());
            updatedProduto.setDescricao(produto.getDescricao());
            updatedProduto.setPreco(produto.getPreco());
            return produtoRepository.save(updatedProduto);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não há nenhum cliente com o id: " + id));

    }

    @DeleteMapping("/produto/delete/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }


}
