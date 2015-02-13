/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat.Familias;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 
 */
public class Familiar {

    private int Id;
    private String Nome;
    private String EstadoCivil;
    private Date DtNascimento;
    private String Escolaridade;
    private String Ocupacao;    
    private String grau;

    public Familiar() {
    }

    
    
    public Familiar(int Id, String Nome, String EstadoCivil, Date DtNascimento, String Escolaridade, String Ocupacao, String grau) {
        this.Id = Id;
        this.Nome = Nome;
        this.EstadoCivil = EstadoCivil;
        this.DtNascimento = DtNascimento;
        this.Escolaridade = Escolaridade;
        this.Ocupacao = Ocupacao;
        this.grau = grau;
    }

    public int getId() {
        return Id;
    }
    public String getNome() {
        return Nome;
    }
    public String getEstadoCivil() {
        return EstadoCivil;
    }
    public Date getDtNascimento() {
        return DtNascimento;
    }
    public String getEscolaridade() {
        return Escolaridade;
    }
    public String getOcupacao() {
        return Ocupacao;
    }
    public String getGrau() {
        return grau;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }
    public void setDtNascimento(Date DtNascimento) {
        this.DtNascimento = DtNascimento;
    }
    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }
    public void setOcupacao(String Ocupacao) {
        this.Ocupacao = Ocupacao;
    }
    public void setGrau(String grau) {
        this.grau = grau;
    }

    @Override
    public String toString() {
        return "Familiar{" + "Id=" + Id + ", Nome=" + Nome + ", EstadoCivil=" + EstadoCivil + ", DtNascimento=" + DtNascimento + ", Escolaridade=" + Escolaridade + ", Ocupacao=" + Ocupacao + ", grau=" + grau + '}';
    }
    
    /**
     * Usada para popular DefaultTableModel
     * @return
     */
    public Object[] getRowData() {
        Object[] ret = {Id,Nome,grau,EstadoCivil,Escolaridade,DtNascimento,Ocupacao};
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.Id;
        hash = 89 * hash + Objects.hashCode(this.Nome);
        hash = 89 * hash + Objects.hashCode(this.EstadoCivil);
        hash = 89 * hash + Objects.hashCode(this.DtNascimento);
        hash = 89 * hash + Objects.hashCode(this.Escolaridade);
        hash = 89 * hash + Objects.hashCode(this.Ocupacao);
        hash = 89 * hash + Objects.hashCode(this.grau);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Familiar other = (Familiar) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.EstadoCivil, other.EstadoCivil)) {
            return false;
        }
        if (!Objects.equals(this.DtNascimento, other.DtNascimento)) {
            return false;
        }
        if (!Objects.equals(this.Escolaridade, other.Escolaridade)) {
            return false;
        }
        if (!Objects.equals(this.Ocupacao, other.Ocupacao)) {
            return false;
        }
        if (!Objects.equals(this.grau, other.grau)) {
            return false;
        }
        return true;
    }

   
    
    
}
