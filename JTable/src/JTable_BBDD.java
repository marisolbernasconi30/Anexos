package JTable;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;



public class JTable_BBDD {
    public static void main(String[] args) {
       
        JFrame mimarco = new MarcoDelArbol();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);
    }
}
class MarcoDelArbol extends JFrame {
    public MarcoDelArbol() {
        
        setTitle("Prueba de lista");
        
        setBounds(400, 300, 500, 400);

         // Inicializar combo
        //nombresDeTablas = new JComboBox<>(new String[] {
           // "Planetas", "Lunas", "Satélites"
       // });

        JPanel superior= new JPanel();
        nombresDeTablas = new JComboBox();
        //empezamos con la conexion a la BBDD
        try {
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", ""); //establecemos la conexion
            datosBBDD = miconexion.getMetaData(); //creamos el objeto para obtener los metadatos    
            rs = datosBBDD.getTables(null, null, null, null); //obtenemos las tablas de la BBDD
          
            while (rs.next()) {
                nombresDeTablas.addItem(rs.getString("TABLE_NAME")); //agregamos los nombres de las tablas al JComboBox
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

nombresDeTablas.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String tablaSeleccionada = (String) nombresDeTablas.getSelectedItem();
        
        String consulta = "SELECT * FROM " + tablaSeleccionada;
    try{
           sentencia = miconexion.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY
         );
        rs2 = sentencia.executeQuery(consulta);
        
       // while (rs2.next()) {
       //     System.out.println(rs2.getString(1) + " " + rs2.getString(2)); //ajustar según el número de columnas
       // }

        modelo = new ResultSetModeloTabla(rs2);
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        validate(); //para que se actualice el JFrame y muestre la nueva tabla


    } catch (Exception e2){
        e2.printStackTrace();
    }
    
    }

});


    superior.add(nombresDeTablas); //agrega el JcomboBox al JPanel

    add(superior, BorderLayout.NORTH);


} 

    private JComboBox nombresDeTablas;
    private DatabaseMetaData datosBBDD;  //para obtener los metadatos de la BBDD
    private ResultSet rs; //para recorrer los resultados de las consultas
    private Connection miconexion; //para establecer la conexion con la BBDD

    private Statement sentencia;
    private ResultSet rs2; //para recorrer los resultados de las consultas

    private ResultSetModeloTabla modelo;

}

class ResultSetModeloTabla extends AbstractTableModel {
    
     public ResultSetModeloTabla (ResultSet unResultset) {

     rsRegistros = unResultset; //asignamos el ResultSet pasado como parametro a la variable de instancia para usarla en otros metodos


     try {
         rsMetadatos = rsRegistros.getMetaData(); //obtenemos los metadatos del ResultSet
     } catch (SQLException e) {
         e.printStackTrace();
     }

  
    }


    @Override
    public int getColumnCount() { //devuelve el numero de columnas del ResultSet
       try {
        return rsMetadatos.getColumnCount();
       } catch (Exception e) {
        e.printStackTrace();
        return 0;
       } 
    }
    @Override
    public int getRowCount() { //devuelve el numero de filas del ResultSet
        
        try {
            rsRegistros.last(); //nos situamos en la ultima fila del ResultSet
            return rsRegistros.getRow(); //devolvemos el numero de fila actual, que es el numero de filas totales
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }  
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{

          rsRegistros.absolute(rowIndex + 1); //nos situamos en la fila rowIndex (sumamos 1 porque las filas empiezan en 1)
          return rsRegistros.getObject(columnIndex + 1); //devolvemos el valor de la columna columnIndex (sumamos 1 porque las columnas empiezan en 1)

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public String getColumnName(int column) { //devuelve el nombre de la columna column
        try {
            return rsMetadatos.getColumnName(column + 1); //devolvemos el nombre de la columna column (sumamos 1 porque las columnas empiezan en 1)
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private ResultSet rsRegistros;
    private ResultSetMetaData rsMetadatos;


}
/*
*  pwd
*
* cd /home/marisol/eclipse-workspace/PROYECTO/Anexo/JTable
*
* ls lib/mysql-connector-java-9.4.0.jar
*
* ls ~/eclipse-workspace/PROYECTO/Anexo/JTable/lib/mysql-connector-java-9.4.0.jar
*
*
javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/JTable_BBDD.java
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" JTable.JTable_BBDD
*/

