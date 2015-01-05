/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import java.util.Date;

/**
 *
 * @author nelson
 */
public class Tarefa {
    private int Id;
    private String Descricao;
    private int Fase_Id;
    private Date Data_Inicio;
    private Date Data_Conclusão;

    public Tarefa() {
    }
        
    public Tarefa(String Descricao, int Fase_Id, Date Data_Inicio, Date Data_Conclusão) {
        this.Descricao = Descricao;
        this.Fase_Id = Fase_Id;
        this.Data_Inicio = Data_Inicio;
        this.Data_Conclusão = Data_Conclusão;
    }

    public int getId() {
        return Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public int getFase_Id() {
        return Fase_Id;
    }

    public Date getData_Inicio() {
        return Data_Inicio;
    }

    public Date getData_Conclusão() {
        return Data_Conclusão;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setFase_Id(int Fase_Id) {
        this.Fase_Id = Fase_Id;
    }

    public void setData_Inicio(Date Data_Inicio) {
        this.Data_Inicio = Data_Inicio;
    }

    public void setData_Conclusão(Date Data_Conclusão) {
        this.Data_Conclusão = Data_Conclusão;
    }

    @Override
    public String toString() {
        return Descricao ;
    }


    
    
    
    
    
}