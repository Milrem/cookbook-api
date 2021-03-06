package br.com.letscode.cookbook.cookbookapi.model;

import br.com.letscode.cookbook.cookbookapi.enums.TipoMedida;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "receita_ingrediente", schema = "cookbook")
@Getter
@Setter
public class ReceitaIngrediente {
    @EmbeddedId
    private ReceitaIngredientePK id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "tipo_medida", length = 30)
    @Enumerated(EnumType.STRING)
    private TipoMedida tipoMedida;

    @ManyToOne
    @MapsId("receitaNome")
    @JoinColumn(name = "receita_nome")
    private Receita receita;

    @ManyToOne
    @MapsId("ingredienteNome")
    @JoinColumn(name = "ingrediente_nome")
    private Ingrediente ingrediente;
}
