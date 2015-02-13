/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat.Fundos;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 
 */
public class RegistoVoluntariado {
    
    private int Tarefa_Id;
    private float Tempo;
    private int Funcionario_Id;
    private String Equipa;
    private int Voluntario_Id;
    private int Id;



    public RegistoVoluntariado() {
    }

    public RegistoVoluntariado(int Tarefa_Id, float Tempo, int Funcionario_Id, String Equipa, int Voluntario_Id) {
        this.Id=-1;
        this.Tarefa_Id = Tarefa_Id;
        this.Tempo = Tempo;
        this.Funcionario_Id = Funcionario_Id;
        this.Equipa = Equipa;
        this.Voluntario_Id = Voluntario_Id;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    public int getTarefa_Id() {
        return Tarefa_Id;
    }

    public void setTarefa_Id(int Tarefa_Id) {
        this.Tarefa_Id = Tarefa_Id;
    }

    public float getTempo() {
        return Tempo;
    }

    public void setTempo(float Tempo) {
        this.Tempo = Tempo;
    }

    public int getFuncionario_Id() {
        return Funcionario_Id;
    }

    public void setFuncionario_Id(int Funcionario_Id) {
        this.Funcionario_Id = Funcionario_Id;
    }

    public String getEquipa() {
        return Equipa;
    }

    public void setEquipa(String Equipa) {
        this.Equipa = Equipa;
    }

    public int getVoluntario_Id() {
        return Voluntario_Id;
    }

    public void setVoluntario_Id(int Voluntario_Id) {
        this.Voluntario_Id = Voluntario_Id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.Tarefa_Id;
        hash = 17 * hash + Float.floatToIntBits(this.Tempo);
        hash = 17 * hash + this.Funcionario_Id;
        hash = 17 * hash + Objects.hashCode(this.Equipa);
        hash = 17 * hash + this.Voluntario_Id;
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
        final RegistoVoluntariado other = (RegistoVoluntariado) obj;
        if (this.Tarefa_Id != other.Tarefa_Id) {
            return false;
        }
        if (Float.floatToIntBits(this.Tempo) != Float.floatToIntBits(other.Tempo)) {
            return false;
        }
        if (this.Funcionario_Id != other.Funcionario_Id) {
            return false;
        }
        if (!Objects.equals(this.Equipa, other.Equipa)) {
            return false;
        }
        if (this.Voluntario_Id != other.Voluntario_Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistoVoluntariado{" + "Tarefa_Id=" + Tarefa_Id + ", Tempo=" + Tempo + ", Funcionario_Id=" + Funcionario_Id + ", Equipa=" + Equipa + ", Voluntario_Id=" + Voluntario_Id + '}';
    }
 
    
}
