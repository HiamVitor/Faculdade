
package fontes;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExemploDataTime {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        LocalDate data1 = LocalDate.of(2019, 2, 20);
        LocalDate data2 = LocalDate.of(2019, Month.NOVEMBER, 1);
        //
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //      
        LocalDate data3 = LocalDate.parse("02/03/2018", formato);
        //
        Period periodo = Period.between(data3, data);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();
        System.out.println("Dias:"+dias+" Meses:"+meses+" Anos:"+anos);
        //
        long numeroDias = data3.until(data, ChronoUnit.WEEKS);
        System.out.println("Dias:"+numeroDias);
        
        System.out.println(data.format(formato));
        System.out.println(data1.format(formato));
        System.out.println(data2);
        System.out.println(data3);
    }
    
}
