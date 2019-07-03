package org.brazil.generation.gfood.cliente;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String endereco;

    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

}
