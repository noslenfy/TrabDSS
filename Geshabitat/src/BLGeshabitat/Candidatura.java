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
    private String Nacionalidade;
    private String Profissao;
    private float Rendimento;
    private String Estado;
    private String Escolaridade;
    private int Funcionario;
    private int Projecto;
    private float Prestacao;
    private String EstadoCivil;
    
    private List<String> Anexos;
    private List<Familiar> Agregado;

    public Candidatura(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String Nacionalidade,
                       String Profissao, float Rendimento, String Estado, String Escolaridade, int Funcionario, int Projecto, float Prestacao, String EstadoCivil,
                       List<String> Anexos, List<Familiar> Agregado) {
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.Nacionalidade = Nacionalidade;
        this.Profissao = Profissao;
        this.Rendimento = Rendimento;
        this.Estado = Estado;
        this.Escolaridade = Escolaridade;
        this.Funcionario = Funcionario;
        this.Projecto = Projecto;
        this.Prestacao = Prestacao;
        this.EstadoCivil = EstadoCivil;
        this.Anexos = Anexos;
        this.Agregado = Agregado;
    }

    public Candidatura(int Nif, String Nome, String Telefone, String Email, String Rua, String Localidade, String Cp, Date DtNascimento, String Nacionalidade,
                        String Profissao, float Rendimento, String Estado, String Escolaridade, int Funcionario, int Projecto, float Prestacao, String EstadoCivil) {
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Localidade = Localidade;
        this.Cp = Cp;
        this.DtNascimento = DtNascimento;
        this.Nacionalidade = Nacionalidade;
        this.Profissao = Profissao;
        this.Rendimento = Rendimento;
        this.Estado = Estado;
        this.Escolaridade = Escolaridade;
        this.Funcionario = Funcionario;
        this.Projecto = Projecto;
        this.Prestacao = Prestacao;
        this.EstadoCivil = EstadoCivil;
    }

    
    public List<String> getAnexos() {
        return Anexos;
    }
    public List<Familiar> getAgregado() {
        return Agregado;
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
    public String getNacionalidade() {
        return Nacionalidade;
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
    public int getFuncionario() {
        return Funcionario;
    }
    public int getProjecto() {
        return Projecto;
    }
    public float getPrestacao() {
        return Prestacao;
    }
    public String getEstadoCivil() {
        return EstadoCivil;
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
    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
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
    public void setFuncionario(int Funcionario) {
        this.Funcionario = Funcionario;
    }
    public void setProjecto(int Projecto) {
        this.Projecto = Projecto;
    }
    public void setPrestacao(float Prestacao) {
        this.Prestacao = Prestacao;
    }
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }
    public void setAnexos(List<String> Anexos) {
        this.Anexos = Anexos;
    }
    public void setAgregado(List<Familiar> Agregado) {
        this.Agregado = Agregado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.Id;
        hash = 53 * hash + this.Nif;
        hash = 53 * hash + Objects.hashCode(this.Nome);
        hash = 53 * hash + Objects.hashCode(this.Telefone);
        hash = 53 * hash + Objects.hashCode(this.Email);
        hash = 53 * hash + Objects.hashCode(this.Rua);
        hash = 53 * hash + Objects.hashCode(this.Localidade);
        hash = 53 * hash + Objects.hashCode(this.Cp);
        hash = 53 * hash + Objects.hashCode(this.DtNascimento);
        hash = 53 * hash + Objects.hashCode(this.Nacionalidade);
        hash = 53 * hash + Objects.hashCode(this.Profissao);
        hash = 53 * hash + Float.floatToIntBits(this.Rendimento);
        hash = 53 * hash + Objects.hashCode(this.Estado);
        hash = 53 * hash + Objects.hashCode(this.Escolaridade);
        hash = 53 * hash + this.Funcionario;
        hash = 53 * hash + this.Projecto;
        hash = 53 * hash + Float.floatToIntBits(this.Prestacao);
        hash = 53 * hash + Objects.hashCode(this.EstadoCivil);
        hash = 53 * hash + Objects.hashCode(this.Anexos);
        hash = 53 * hash + Objects.hashCode(this.Agregado);
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
        if (!Objects.equals(this.Nacionalidade, other.Nacionalidade)) {
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
        if (this.Funcionario != other.Funcionario) {
            return false;
        }
        if (this.Projecto != other.Projecto) {
            return false;
        }
        if (Float.floatToIntBits(this.Prestacao) != Float.floatToIntBits(other.Prestacao)) {
            return false;
        }
        if (!Objects.equals(this.EstadoCivil, other.EstadoCivil)) {
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

   
    
    
    
}

