package Model;

import java.awt.Color;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SwingColumn {

    String description();

    String colorOfBackgound() default "";
}
