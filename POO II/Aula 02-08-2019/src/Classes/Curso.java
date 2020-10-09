
package Classes;

import Abstratas.Dados;
import Enums.TipoTurno;

public class Curso extends Dados{
    private int carga;
    private Professor coordenador;
    private TipoTurno turno;
    //
    public Curso(){
        super();
        this.setCarga(0);
        this.setCoordenador(null);
        this.setTurno(TipoTurno.M);
    }
    public Curso(String nome,int carga, Professor coordenador,
            TipoTurno turno){
        super(nome);
        this.setCarga(carga);
        this.setCoordenador(coordenador);
        this.setTurno(turno);        
    }
    //
    public void setCarga(int carga){
        this.carga = carga <= 0 ? 1 : carga;
    }
    public void setCoordenador(Professor coordenador){
        this.coordenador = coordenador == null ?
                new Professor() : coordenador;
    }
    public void setTurno(TipoTurno turno){
        this.turno=turno==null ? TipoTurno.M : turno;
    }
    //
    public int getCarga(){
        return this.carga;
    }
    public Professor getCoordenador(){
        return this.coordenador;
    }
    public TipoTurno getTurno(){
        return this.turno;
    }
}
