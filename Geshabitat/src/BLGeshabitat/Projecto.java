/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author nelson
 */
public class Projecto {
    private int Id;
    private String Rua;
    private float CustoFinal;
    private float Orcamento;
    private Date DtInicioProjecto;
    private Date DtConclusaoProjecto;
    private String Descricao;
    private String Localidade;
    private int Funcionario_Id;
    private String Cp;
    private int Candidatura_Id;

    public Projecto() {
    }


    public Projecto(String Rua, float CustoFinal, float Orcamento, Date DtInicioProjecto, Date DtConclusaoProjecto, String Descricao, String Localidade, int Funcionario_Id, String Cp, int Candidatura_Id) {
       this.Id = -1;
        this.Rua = Rua;
        this.CustoFinal = CustoFinal;
        this.Orcamento = Orcamento;
        this.DtInicioProjecto = DtInicioProjecto;
        this.DtConclusaoProjecto = DtConclusaoProjecto;
        this.Descricao = Descricao;
        this.Localidade = Localidade;
        this.Funcionario_Id = Funcionario_Id;
        this.Cp = Cp;
        this.Candidatura_Id = Candidatura_Id;
    }

    public int getId() {
        return Id;
    }

    public String getRua() {
        return Rua;
    }

    public float getCustoFinal() {
        return CustoFinal;
    }

    public float getOrcamento() {
        return Orcamento;
    }

    public Date getDtInicioProjecto() {
        return DtInicioProjecto;
    }

    public Date getDtConclusaoProjecto() {
        return DtConclusaoProjecto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public String getLocalidade() {
        return Localidade;
    }

    public int getFuncionario_Id() {
        return Funcionario_Id;
    }

    public String getCp() {
        return Cp;
    }

    public int getCandidatura_Id() {
        return Candidatura_Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public void setCustoFinal(float CustoFinal) {
        this.CustoFinal = CustoFinal;
    }

    public void setOrcamento(float Orcamento) {
        this.Orcamento = Orcamento;
    }

    public void setDtInicioProjecto(Date DtInicioProjecto) {
        this.DtInicioProjecto = DtInicioProjecto;
    }

    public void setDtConclusaoProjecto(Date DtConclusaoProjecto) {
        this.DtConclusaoProjecto = DtConclusaoProjecto;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setLocalidade(String Localidade) {
        this.Localidade = Localidade;
    }

    public void setFuncionario_Id(int Funcionario_Id) {
        this.Funcionario_Id = Funcionario_Id;
    }

    public void setCp(String Cp) {
        this.Cp = Cp;
    }

    public void setCandidatura_Id(int Candidatura_Id) {
        this.Candidatura_Id = Candidatura_Id;
    }

    @Override
    public String toString() {
        return Descricao +" - " + Localidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.Id;
        hash = 13 * hash + Objects.hashCode(this.Rua);
        hash = 13 * hash + Float.floatToIntBits(this.CustoFinal);
        hash = 13 * hash + Float.floatToIntBits(this.Orcamento);
        hash = 13 * hash + Objects.hashCode(this.DtInicioProjecto);
        hash = 13 * hash + Objects.hashCode(this.DtConclusaoProjecto);
        hash = 13 * hash + Objects.hashCode(this.Descricao);
        hash = 13 * hash + Objects.hashCode(this.Localidade);
        hash = 13 * hash + this.Funcionario_Id;
        hash = 13 * hash + Objects.hashCode(this.Cp);
        hash = 13 * hash + this.Candidatura_Id;
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
        final Projecto other = (Projecto) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Rua, other.Rua)) {
            return false;
        }
        if (Float.floatToIntBits(this.CustoFinal) != Float.floatToIntBits(other.CustoFinal)) {
            return false;
        }
        if (Float.floatToIntBits(this.Orcamento) != Float.floatToIntBits(other.Orcamento)) {
            return false;
        }
        if (!Objects.equals(this.DtInicioProjecto, other.DtInicioProjecto)) {
            return false;
        }
        if (!Objects.equals(this.DtConclusaoProjecto, other.DtConclusaoProjecto)) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        if (!Objects.equals(this.Localidade, other.Localidade)) {
            return false;
        }
        if (this.Funcionario_Id != other.Funcionario_Id) {
            return false;
        }
        if (!Objects.equals(this.Cp, other.Cp)) {
            return false;
        }
        return this.Candidatura_Id == other.Candidatura_Id;
    }
  
    
    public Object[] getRowData() {
        Object[] ret = {Id,Descricao,Localidade,DtInicioProjecto};
        return ret;
    }

    
}
