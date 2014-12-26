/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author nelson
 */
public class Doador {
    private int Id;
    private int Nif;
    private String Nome;
    private String Telefone;
    private String Email;
    private String Rua;
    private String Localidade;
    private String Cp;
    private Date DtNascimento;
    private String EstadoCivil;
    private String Profissao;
    private String Actividade;
    private String Tipo;
    private boolean Parceria;

    public Doador() {
    }
    public Doador(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String EstadoCivil, String Profissao, String Actividade, String Tipo, boolean Parceria) {
        this.Id = Id;
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.EstadoCivil = EstadoCivil;
        this.Profissao = Profissao;
        this.Actividade = Actividade;
        this.Tipo = Tipo;
        this.Parceria = Parceria;
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
    public String getEstadoCivil() {
        return EstadoCivil;
    }
    public String getProfissao() {
        return Profissao;
    }
    public String getActividade() {
        return Actividade;
    }
    public String getTipo() {
        return Tipo;
    }
    public boolean isParceria() {
        return Parceria;
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
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }
    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }
    public void setActividade(String Actividade) {
        this.Actividade = Actividade;
    }
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    public void setParceria(boolean Parceria) {
        this.Parceria = Parceria;
    }

    @Override
    public String toString() {
        return "Doador{" + "Id=" + Id + ", Nif=" + Nif + ", Nome=" + Nome + ", Telefone=" + Telefone + ", Email=" + Email + ", Rua=" + Rua + ", Localidade=" + Localidade + ", Cp=" + Cp + ", DtNascimento=" + DtNascimento + ", EstadoCivil=" + EstadoCivil + ", Profissao=" + Profissao + ", Actividade=" + Actividade + ", Tipo=" + Tipo + ", Parceria=" + Parceria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Id;
        hash = 53 * hash + this.Nif;
        hash = 53 * hash + Objects.hashCode(this.Nome);
        hash = 53 * hash + Objects.hashCode(this.Telefone);
        hash = 53 * hash + Objects.hashCode(this.Email);
        hash = 53 * hash + Objects.hashCode(this.Rua);
        hash = 53 * hash + Objects.hashCode(this.Localidade);
        hash = 53 * hash + Objects.hashCode(this.Cp);
        hash = 53 * hash + Objects.hashCode(this.DtNascimento);
        hash = 53 * hash + Objects.hashCode(this.EstadoCivil);
        hash = 53 * hash + Objects.hashCode(this.Profissao);
        hash = 53 * hash + Objects.hashCode(this.Actividade);
        hash = 53 * hash + Objects.hashCode(this.Tipo);
        hash = 53 * hash + (this.Parceria ? 1 : 0);
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
        final Doador other = (Doador) obj;
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
        if (!Objects.equals(this.EstadoCivil, other.EstadoCivil)) {
            return false;
        }
        if (!Objects.equals(this.Profissao, other.Profissao)) {
            return false;
        }
        if (!Objects.equals(this.Actividade, other.Actividade)) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (this.Parceria != other.Parceria) {
            return false;
        }
        return true;
    }
    
    
    @Override
    protected Object clone() {
        return new Doador(this.Nif,this.Nome,this.Telefone,this.Email,this.Rua,this.Localidade,this.Cp,this.DtNascimento,this.EstadoCivil,this.Profissao, this.Actividade, this.Tipo, this.Parceria);
    }




}
