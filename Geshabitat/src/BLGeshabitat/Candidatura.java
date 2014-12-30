/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author nelson
 */
public class Candidatura {
    private int Id;
    private int Nif;
    private String Nome;
    private String Telefone;
    private String Email;
    private String Rua;
    private String Localidade;
    private String Cp;
    private Date DtNascimento;
    private String Profissao;
    private float Rendimento;
    private String Estado;
    private String Escolaridade;
    private int Funcionario_Id;
    private float Prestacao;
    private String EstadoCivil;
    private String Telemovel;
        
    
    private List<Anexo> Anexos;
    private List<Familiar> Agregado;

    public Candidatura() {
    }

    
    
    public Candidatura(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String Profissao,
                        float Rendimento, String Estado, String Escolaridade, int Funcionario_Id, float Prestacao, String EstadoCivil, String Telemovel, List<Anexo> Anexos, List<Familiar> Agregado) {
        this.Id = -1;
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.Profissao = Profissao;
        this.Rendimento = Rendimento;
        this.Estado = Estado;
        this.Escolaridade = Escolaridade;
        this.Funcionario_Id = Funcionario_Id;
        this.Prestacao = Prestacao;
        this.EstadoCivil = EstadoCivil;
        this.Telemovel = Telemovel;
        this.Anexos = Anexos;
        this.Agregado = Agregado;
    }
    
    
    public Candidatura(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String Profissao,
                        float Rendimento, String Estado, String Escolaridade, int Funcionario_Id, float Prestacao, String EstadoCivil, String Telemovel) {
        this.Id=-1;
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.Profissao = Profissao;
        this.Rendimento = Rendimento;
        this.Estado = Estado;
        this.Escolaridade = Escolaridade;
        this.Funcionario_Id = Funcionario_Id;
        this.Prestacao = Prestacao;
        this.EstadoCivil = EstadoCivil;
        this.Telemovel = Telemovel;
    }

    
    
    public int getId() {
        return Id;
    }
    public int getNif() {
        return Nif;
    }
    public String getNome() {
        return Nome;
    }
    public String getTelefone() {
        return Telefone;
    }
    public String getEmail() {
        return Email;
    }
    public String getRua() {
        return Rua;
    }
    public String getLocalidade() {
        return Localidade;
    }
    public String getCp() {
        return Cp;
    }
    public Date getDtNascimento() {
        return DtNascimento;
    }

    public String getProfissao() {
        return Profissao;
    }
    public float getRendimento() {
        return Rendimento;
    }
    public String getEstado() {
        return Estado;
    }
    public String getEscolaridade() {
        return Escolaridade;
    }
    public int getFuncionario_Id() {
        return Funcionario_Id;
    }
    public float getPrestacao() {
        return Prestacao;
    }
    public String getEstadoCivil() {
        return EstadoCivil;
    }
    public String getTelemovel() {
        return Telemovel;
    }
    public List<Anexo> getAnexos() {
        return Anexos;
    }
    public List<Familiar> getAgregado() {
        return Agregado;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public void setNif(int Nif) {
        this.Nif = Nif;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setRua(String Rua) {
        this.Rua = Rua;
    }
    public void setLocalidade(String Localidade) {
        this.Localidade = Localidade;
    }
    public void setCp(String Cp) {
        this.Cp = Cp;
    }
    public void setDtNascimento(Date DtNascimento) {
        this.DtNascimento = DtNascimento;
    }

    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }
    public void setRendimento(float Rendimento) {
        this.Rendimento = Rendimento;
    }
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }
    public void setFuncionario_Id(int Funcionario_Id) {
        this.Funcionario_Id = Funcionario_Id;
    }
    public void setPrestacao(float Prestacao) {
        this.Prestacao = Prestacao;
    }
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }
    public void setTelemovel(String Telemovel) {
        this.Telemovel = Telemovel;
    }
    public void setAnexos(List<Anexo> Anexos) {
        this.Anexos = Anexos;
    }
    public void setAgregado(List<Familiar> Agregado) {
        this.Agregado = Agregado;
    }

    @Override
    public String toString() {
        return "Candidatura{" + "Id=" + Id + ", Nif=" + Nif + ", Nome=" + Nome + ", Telefone=" + Telefone + ", Email=" + Email + ", Rua=" + Rua + ", Localidade=" + Localidade + ", Cp=" + Cp + ", DtNascimento=" + DtNascimento + ", Profissao=" + Profissao + ", Rendimento=" + Rendimento + ", Estado=" + Estado + ", Escolaridade=" + Escolaridade + ", Funcionario_Id=" + Funcionario_Id +  ", Prestacao=" + Prestacao + ", EstadoCivil=" + EstadoCivil + ", Telemovel=" + Telemovel + ", Anexos=" + Anexos + ", Agregado=" + Agregado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.Id;
        hash = 41 * hash + this.Nif;
        hash = 41 * hash + Objects.hashCode(this.Nome);
        hash = 41 * hash + Objects.hashCode(this.Telefone);
        hash = 41 * hash + Objects.hashCode(this.Email);
        hash = 41 * hash + Objects.hashCode(this.Rua);
        hash = 41 * hash + Objects.hashCode(this.Localidade);
        hash = 41 * hash + Objects.hashCode(this.Cp);
        hash = 41 * hash + Objects.hashCode(this.DtNascimento);
        hash = 41 * hash + Objects.hashCode(this.Profissao);
        hash = 41 * hash + Float.floatToIntBits(this.Rendimento);
        hash = 41 * hash + Objects.hashCode(this.Estado);
        hash = 41 * hash + Objects.hashCode(this.Escolaridade);
        hash = 41 * hash + this.Funcionario_Id;
        hash = 41 * hash + Float.floatToIntBits(this.Prestacao);
        hash = 41 * hash + Objects.hashCode(this.EstadoCivil);
        hash = 41 * hash + Objects.hashCode(this.Telemovel);
        hash = 41 * hash + Objects.hashCode(this.Anexos);
        hash = 41 * hash + Objects.hashCode(this.Agregado);
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
        final Candidatura other = (Candidatura) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.Nif != other.Nif) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Telefone, other.Telefone)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Rua, other.Rua)) {
            return false;
        }
        if (!Objects.equals(this.Localidade, other.Localidade)) {
            return false;
        }
        if (!Objects.equals(this.Cp, other.Cp)) {
            return false;
        }
        if (!Objects.equals(this.DtNascimento, other.DtNascimento)) {
            return false;
        }
        if (!Objects.equals(this.Profissao, other.Profissao)) {
            return false;
        }
        if (Float.floatToIntBits(this.Rendimento) != Float.floatToIntBits(other.Rendimento)) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        if (!Objects.equals(this.Escolaridade, other.Escolaridade)) {
            return false;
        }
        if (this.Funcionario_Id != other.Funcionario_Id) {
            return false;
        }
        if (Float.floatToIntBits(this.Prestacao) != Float.floatToIntBits(other.Prestacao)) {
            return false;
        }
        if (!Objects.equals(this.EstadoCivil, other.EstadoCivil)) {
            return false;
        }
        if (!Objects.equals(this.Telemovel, other.Telemovel)) {
            return false;
        }
        if (!Objects.equals(this.Anexos, other.Anexos)) {
            return false;
        }
        if (!Objects.equals(this.Agregado, other.Agregado)) {
            return false;
        }
        return true;
    } 
    
    public Object[] getRowData() {
        Object[] ret = {Id,Nome,Nif,Localidade,Estado};
        return ret;
    }
}

