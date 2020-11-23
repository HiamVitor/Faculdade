
package Testes;

import Controller.daoFuncionario;
import Model.Funcionario;

public class testeCrudFuncionario {
    public static void main(String[] args) {
        daoFuncionario dao = new daoFuncionario();
        //
        Funcionario f1 = new Funcionario(0, "zeca", "(00)99999-8888");
        Funcionario f2 = new Funcionario(0, "julia", "(00)99988-1234");
        Funcionario f3 = new Funcionario(0, "carol", "(48)99786-1122");
        Funcionario f4 = new Funcionario(0, "abreu", "(49)91234-8888");
        //
        try{
            dao.add(f1);
            dao.add(f2);
            dao.add(f3);
            dao.add(f4);
            System.out.println("Adicionado");
            //
        }catch(Exception ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
    }
    
}
