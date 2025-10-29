import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class App {
    public static void main(String[] args)  {
        
        JFrame mimarco = new MarcoDeLista();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);

    }
}

class MarcoDeLista extends JFrame {
    public MarcoDeLista() {
        
        setTitle("Prueba de lista");
        
        setBounds(400, 300, 500, 400);

        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
       
        listaMeses = new JList<String>(meses);
        listaMeses.setVisibleRowCount(4); //la cantidad de elementos que quiero ver

        JScrollPane laminaConScroll = new JScrollPane(listaMeses);
        laminaLista = new JPanel();
        laminaLista.add(laminaConScroll);


        listaMeses.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
            List<String> seleccion = listaMeses.getSelectedValuesList();
            StringBuilder texto = new StringBuilder("Mes seleccionado: ");
            for (String elemento : seleccion) {
                String palabra=elemento;
                texto.append(palabra);
                texto.append(" ");

            
            }

            rotulo.setText(texto.toString());
            
         }
            
        });

        laminaTexto = new JPanel();
        rotulo = new JLabel("Mes seleccionado:");
        laminaTexto.add(rotulo);

        add(laminaLista, BorderLayout.NORTH);
        add(laminaTexto, BorderLayout.SOUTH);

    }

    private JList<String> listaMeses;
    private JPanel laminaLista, laminaTexto;
    private JLabel rotulo;
}

