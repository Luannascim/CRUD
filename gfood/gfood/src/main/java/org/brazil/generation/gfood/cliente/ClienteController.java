package org.brazil.generation.gfood.cliente;

import org.brazil.generation.gfood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cliente")
    public Cliente save(@RequestBody Cliente cliente) {
        return  clienteRepository.save(cliente); // CREATE
    }

    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        return clienteRepository.findAll(); //READ
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> findByid(@PathVariable Long id) {
        return clienteRepository.findById(id);

    }

    @PutMapping("/cliente/id")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) throws ResourceNotFoundException {
        return clienteRepository.findById(id).map(updatedCliente -> {
            updatedCliente.setNome(cliente.getNome());
            updatedCliente.setEndereco(cliente.getEndereco());
            updatedCliente.setDataNascimento(cliente.getDataNascimento());
            return clienteRepository.save(updatedCliente);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não há nenhum cliente com o id: " +id));
    }

    @DeleteMapping("/cliente/delete/{id}")
    public void delete(@PathVariable Long id) {
        clienteRepository.deleteById(id); //delete

    }

    @GetMapping("/cliente/nome/{nome}")
    public Cliente  findByNome(@PathVariable String nome){
        return clienteRepository.findByNome(nome);
    }

    @PostMapping ("/cliente/dataNascimento/")
    public Cliente findByNomeAndDataNascimento(@RequestParam String nome, Date dataNascimento) {
        return  clienteRepository.findByNomeAndDataNascimento(nome, dataNascimento);
    }

}