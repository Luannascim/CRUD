package org.brazil.generation.gfood.cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findByNome(String nome);

    Cliente findByNomeAndDataNascimento(String nome, Date dataNascimento);
}



