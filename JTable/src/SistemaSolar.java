import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SistemaSolar {
    public static void main(String[] args) throws Exception {
       
        JFrame mimarco = new MarcoDelArbol();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);
    }
}



class MarcoDelArbol extends JFrame {
    public MarcoDelArbol() {
        
        setTitle("Prueba de lista");
        
        setBounds(400, 300, 500, 400);

        JTable tablaPlanetas=new JTable(datosFila, nombresColumnas );
        add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);

        JButton botonImprimir=new JButton("Imprimir tabla");
        botonImprimir.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            try{
            tablaPlanetas.print();  //para que nos imprima la tabla, lo puede hacer, literalmente
            }catch(Exception ex){
              ex.printStackTrace();
            }
            
          }
        });

        JPanel laminaBotones=new JPanel();
        laminaBotones.add(botonImprimir);
      add(laminaBotones, BorderLayout.SOUTH);

}
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
    {"Plutón", 1137.0, 1, false}
    };
}


