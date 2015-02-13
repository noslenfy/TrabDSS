/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat.Fundos;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 
 */
public class Doacao {
    private int Id;
    private boolean recibo;
    private Date Data;
    private String Descricao;
    private String Evento;
    private float Valor;
    private int Tipo;  // 0 -> Monetária 1->Material 2->Serviços
    private String Destino;
    private int Projecto_Id;
    private int Doador_Id;
    private List<Material> Materiais;

    
    
    
    public Doacao() {
    }

    public Doacao(boolean recibo, Date Data, String Descricao, String Evento, float Valor, int Tipo, String Destino, int Projecto_Id, int Doador_Id) {
        this.recibo = recibo;
        this.Data = Data;
        this.Descricao = Descricao;
        this.Evento = Evento;
        this.Valor = Valor;
        this.Tipo = Tipo;
        this.Destino = Destino;
        this.Projecto_Id = Projecto_Id;
        this.Doador_Id = Doador_Id;
    }
    
    
    
    
    
    /**
     *  Doação Monetária
     * @param recibo
     * @param Data
     * @param Evento
     * @param Valor
     * @param Destino
     * @param Doador_Id
     */
    public Doacao(boolean recibo, Date Data, String Evento, float Valor, String Destino, int Doador_Id) {
        this.Id = -1;
        this.recibo = recibo;
        this.Data = Data;
        this.Evento = Evento;
        this.Valor = Valor;
        this.Tipo = 0;
        this.Destino = Destino;
        this.Doador_Id = Doador_Id;
        this.Descricao = null;
        this.Projecto_Id = -1;
        this.Materiais = null;
    }

    /**
     * Doacao Serviços
     * @param recibo
     * @param Data
     * @param Descricao
     * @param Destino
     * @param Doador_Id
     */
    public Doacao(boolean recibo, Date Data, String Descricao, String Destino, int Doador_Id) {
        this.Id = -1;
        this.recibo = recibo;
        this.Data = Data;
        this.Evento = null;
        this.Valor = 0;
        this.Descricao = Descricao;
        this.Tipo = 2;
        this.Destino = Destino;
        this.Doador_Id = Doador_Id;
        this.Projecto_Id = -1;
        this.Materiais = null;
    }

    /**
     * Doacao Material
     * @param Data
     * @param Evento
     * @param Destino
     * @param Doador_Id
     */
    public Doacao(Date Data, String Evento, String Destino, int Doador_Id) {
        this.Id = -1;
        this.recibo = false;
        this.Data = Data;
        this.Evento = Evento;
        this.Valor = 0;
        this.Tipo = 1;
        this.Descricao = null;
        this.Destino = Destino;
        this.Doador_Id = Doador_Id;
        this.Projecto_Id = -1;
        this.Materiais = null;        
    }

    public int getId() {
        return Id;
    }
    public boolean isRecibo() {
        return recibo;
    }
    public Date getData() {
        return Data;
    }
    public String getDescricao() {
        return Descricao;
    }
    public String getEvento() {
        return Evento;
    }
    public float getValor() {
        return Valor;
    }
    public int getTipo() {
        return Tipo;
    }
    public String getDestino() {
        return Destino;
    }
    public int getProjecto_Id() {
        return Projecto_Id;
    }
    public int getDoador_Id() {
        return Doador_Id;
    }
    public List<Material> getMateriais() {
        return Materiais;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public void setRecibo(boolean recibo) {
        this.recibo = recibo;
    }
    public void setData(Date Data) {
        this.Data = Data;
    }
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    public void setEvento(String Evento) {
        this.Evento = Evento;
    }
    public void setValor(float Valor) {
        this.Valor = Valor;
    }
    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }
    public void setDestino(String Destino) {
        this.Destino = Destino;
    }
    public void setProjecto_Id(int Projecto_Id) {
        this.Projecto_Id = Projecto_Id;
    }
    public void setDoador_Id(int Doador_Id) {
        this.Doador_Id = Doador_Id;
    }
    public void setMateriais(List<Material> Materiais) {
        this.Materiais = Materiais;
    }

    @Override
    public String toString() {
        return "Doacao{" + "Id=" + Id + ", recibo=" + recibo + ", Data=" + Data + ", Descricao=" + Descricao + ", Evento=" + Evento + ", Valor=" + Valor + ", Tipo=" + Tipo + ", Destino=" + Destino + ", Projecto_Id=" + Projecto_Id + ", Doador_Id=" + Doador_Id + ", Materiais=" + Materiais + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.Id;
        hash = 41 * hash + (this.recibo ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.Data);
        hash = 41 * hash + Objects.hashCode(this.Descricao);
        hash = 41 * hash + Objects.hashCode(this.Evento);
        hash = 41 * hash + Float.floatToIntBits(this.Valor);
        hash = 41 * hash + this.Tipo;
        hash = 41 * hash + Objects.hashCode(this.Destino);
        hash = 41 * hash + this.Projecto_Id;
        hash = 41 * hash + this.Doador_Id;
        hash = 41 * hash + Objects.hashCode(this.Materiais);
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
        final Doacao other = (Doacao) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.recibo != other.recibo) {
            return false;
        }
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        if (!Objects.equals(this.Evento, other.Evento)) {
            return false;
        }
        if (Float.floatToIntBits(this.Valor) != Float.floatToIntBits(other.Valor)) {
            return false;
        }
        if (this.Tipo != other.Tipo) {
            return false;
        }
        if (!Objects.equals(this.Destino, other.Destino)) {
            return false;
        }
        if (this.Projecto_Id != other.Projecto_Id) {
            return false;
        }
        if (this.Doador_Id != other.Doador_Id) {
            return false;
        }
        if (!Objects.equals(this.Materiais, other.Materiais)) {
            return false;
        }
        return true;
    }
    
    
    
}
