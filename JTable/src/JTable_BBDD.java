import java.awt.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
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

        //empezamos con la conexion a la BBDD
        try {
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", ""); //establecemos la conexion
            datosBBDD = miconexion.getMetaData(); //creamos el objeto para obtener los metadatos    
            rs = datosBBDD.getTables(null, null, null, new String[] {"TABLE"}); //obtenemos las tablas de la BBDD
            nombresDeTablas = new JComboBox<>();
            while (rs.next()) {
                nombresDeTablas.addItem(rs.getString("TABLE_NAME")); //agregamos los nombres de las tablas al JComboBox
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





        superior.add(nombresDeTablas); //agrega el JcomboBox al JPanel

        add(superior, BorderLayout.NORTH);


    }

    private JComboBox nombresDeTablas;
    private DatabaseMetaData datosBBDD;  //para obtener los metadatos de la BBDD
    private ResultSet rs; //para recorrer los resultados de las consultas
    private Connection miconexion; //para establecer la conexion con la BBDD




}

/*
*  pwd
*
* cd /home/marisol/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity
*
* ls lib/mysql-connector-java-9.4.0.jar
*
* ls ~/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity/lib/mysql-connector-java-9.4.0.jar
*
*
javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/conectaBD/ModificaBDD.java
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" conectaBD.ModificaBDD
*/

