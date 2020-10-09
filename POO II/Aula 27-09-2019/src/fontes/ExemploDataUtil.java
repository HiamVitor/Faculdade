
package fontes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExemploDataUtil {
    public static void main(String[] args) {
        Date data = new Date();
        //Date data1 = new Date("01/02/2019");
        System.out.println(data);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            data = formato.parse("01/02/2019");
            System.out.println(formato.format(data));
        }catch(ParseException ex){
            System.out.println("ERRO na Data");
        }
    }
}
