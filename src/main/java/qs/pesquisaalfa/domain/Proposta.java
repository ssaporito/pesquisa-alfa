package qs.pesquisaalfa.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Proposta.
 */
@Entity
@Table(name = "proposta")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Proposta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "proposta_aceita", nullable = false)
    private Boolean propostaAceita;

    @Column(name = "tese_aceita")
    private Boolean teseAceita;

    @NotNull
    @Column(name = "tema", nullable = false)
    private String tema;

    @OneToOne
    @NotNull
    @JoinColumn(unique = true)
    private Aluno aluno;

    @ManyToOne
    @NotNull
    private Orientador orientador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isPropostaAceita() {
        return propostaAceita;
    }

    public Proposta propostaAceita(Boolean propostaAceita) {
        this.propostaAceita = propostaAceita;
        return this;
    }

    public void setPropostaAceita(Boolean propostaAceita) {
        this.propostaAceita = propostaAceita;
    }

    public Boolean isTeseAceita() {
        return teseAceita;
    }

    public Proposta teseAceita(Boolean teseAceita) {
        this.teseAceita = teseAceita;
        return this;
    }

    public void setTeseAceita(Boolean teseAceita) {
        this.teseAceita = teseAceita;
    }

    public String getTema() {
        return tema;
    }

    public Proposta tema(String tema) {
        this.tema = tema;
        return this;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Proposta aluno(Aluno aluno) {
        this.aluno = aluno;
        return this;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public Proposta orientador(Orientador orientador) {
        this.orientador = orientador;
        return this;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Proposta proposta = (Proposta) o;
        if(proposta.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, proposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Proposta{" +
            "id=" + id +
            ", propostaAceita='" + propostaAceita + "'" +
            ", teseAceita='" + teseAceita + "'" +
            ", tema='" + tema + "'" +
            '}';
    }
}
