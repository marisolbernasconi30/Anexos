import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JPanel;
public class PriebaJTree {

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
//creamos la estructura del arbol 

        DefeaultModableTreeNode raiz = new DefeaultModableTreeNode("Mundo");
   
            DefeaultModableTreeNode pais = new DefeaultModableTreeNode("Argentina");
       
         raiz.add(pais); // pais es hijo de raiz, o una subcategoria de raiz


// creamos el arbol con la raiz y lo añadimos a la lamina
        JTree arbol = new JTree(raiz);
        
        //LaminaArbol lamina = new LaminaArbol(arbol);
        
        //add(lamina);

        Container laminaContenido= getContentPane(); //nos devuelve un contenedor de la lamina
        laminaContenido.add(new JScrollPane(arbol)); //añadimos el arbol a la lamina con scroll

    }
}

class LaminaArbol extends JPanel{ //creamos la lámina para el arbol
    public LaminaArbol(JTree arbol) {
        setLayout(new BorderLayout());
        add(arbol, BorderLayout.NORTH);
    }
}
