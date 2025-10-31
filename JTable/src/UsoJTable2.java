import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;



public class UsoJTable2 {
    public static void main(String[] args) {
       JFrame mimarco = new MarcoTabla();
       mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
       mimarco.setVisible(true);
   }
}
class MarcoTabla extends JFrame {
   public MarcoTabla() { //metodo contructor
       setTitle("Tabla personalizada");   
       setBounds(400, 300, 500, 400);
TableModel  modelo=new ModeloTablaPersonalizada(); //creo un modelo de tabla personalizado
       JTable tabla=new JTable(modelo); //creo la tabla pasandole el modelo personalizado
       add(new JScrollPane(tabla)); //añado la tabla a la lamina con scrollpane
    }
}

class ModeloTablaPersonalizada extends AbstractTableModel {
    private String [] nombresColumnas={"Nombre", "Radio", "Lunas", "Gaseoso"};

    private Object [][] datosFila={
      {"Mercurio", 2440.0, 0, false},
      {"Venus", 6052.0, 0, false},
      {"Tierra", 6378.0, 1, false},
      {"Marte", 3397.0, 2, false},
      {"Jupiter", 71492.0, 16, true},
      {"Saturno", 60268.0, 18, true},
      {"Urano", 25559.0, 17, true},
      {"Neptuno", 24766.0, 8, true},
      {"Pluton", 1137.0, 1, false}
    };

    public int getRowCount() { //establece la cantidad de filas
        return datosFila.length;
    }

    public int getColumnCount() { //establece la cantidad de columnas
        return nombresColumnas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) { //devuelve el valor de una celda concreta
        return datosFila[rowIndex][columnIndex];
    }

    public String getColumnName(int column) { //devuelve el nombre de una columna concreta
        return nombresColumnas[column];
    }
  
}