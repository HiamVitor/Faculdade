
package Classes;

import Abstratas.Dados;
import Enums.Siglas;

public class Cidade extends Dados{
    private Siglas sigla;
    //
    public Cidade(){
        super();
        this.setSigla(Siglas.SC);
    }
    public Cidade(String nome,Siglas sigla){
        super(nome);
        this.setSigla(sigla);
    }
    //
    public void setSigla(Siglas sigla){
        this.sigla = sigla == null ? Siglas.SC : sigla;
    }
    //
    public Siglas getSigla(){
        return this.sigla;
    }
    
}
