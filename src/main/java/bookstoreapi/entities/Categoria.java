package bookstoreapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria implements Serializable {

    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();


    public Categoria(Long Id, String nome, String descricao) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

    }
}
