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
        return ProdutoRepository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto>findAll(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Optional<Produto>

}
