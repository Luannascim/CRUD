package org.brazil.generation.gfood.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produto")
    public  Produto save(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto>findAll(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Optional<Produto> findByid(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    @PutMapping("/produto/id")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) throws ResourceNotFoundException {
        return produtoRepository.findById(id).map(updatedCliente -> {
            updatedProduto.setNome(produto.getNome());
            updatedProduto.setDescricao(produto.getDescricao());
            updatedProduto.setPreco(produto.getPreco());
            return produtoRepository.save(updatedCliente);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não há nenhum cliente com o id: " +id));



}
