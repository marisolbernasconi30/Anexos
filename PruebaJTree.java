import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JPanel;
public class PruebaJTree {

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

        DefaultMutableTreeNode golosinas = new DefaultMutableTreeNode("Golosinas:");
   
           DefaultMutableTreeNode gomitas = new DefaultMutableTreeNode("Gomitas");
       
         golosinas.add(gomitas); // pais es hijo de raiz, o una subcategoria de raiz

         DefaultMutableTreeNode yogur = new DefaultMutableTreeNode("Sabor Yogur");
         DefaultMutableTreeNode acidas = new DefaultMutableTreeNode("Sabor Acido");
         DefaultMutableTreeNode copos = new DefaultMutableTreeNode("Tamaño de copos");
         DefaultMutableTreeNode grandes = new DefaultMutableTreeNode("Tamaño Grande");

         gomitas.add(yogur);
         gomitas.add(acidas);
         gomitas.add(copos);
         gomitas.add(grandes);
        
         //-----------------------------------

        DefaultMutableTreeNode alfajores = new DefaultMutableTreeNode("Alfajores");
       
         golosinas.add(alfajores); // pais es hijo de raiz, o una subcategoria de raiz

         DefaultMutableTreeNode pistacho = new DefaultMutableTreeNode("Sabor Pistacho");
         DefaultMutableTreeNode chocolate = new DefaultMutableTreeNode("Sabor Chocolate");
         DefaultMutableTreeNode vainilla = new DefaultMutableTreeNode("Sabor Vainilla");
         DefaultMutableTreeNode combinados = new DefaultMutableTreeNode("Combinados: ");

         alfajores.add(pistacho);
         alfajores.add(chocolate);
         alfajores.add(vainilla);
         alfajores.add(combinados);

         DefaultMutableTreeNode combinados1 = new DefaultMutableTreeNode("Frutilla + Chocolate ");
         DefaultMutableTreeNode combinados2 = new DefaultMutableTreeNode("Banana + Chocolate ");
         DefaultMutableTreeNode combinados3 = new DefaultMutableTreeNode("Banana + Dulce de leche ");
         DefaultMutableTreeNode combinados4 = new DefaultMutableTreeNode("Chocolate Dubai");
         
         combinados.add(combinados1);
         combinados.add(combinados2);
         combinados.add(combinados3);
         combinados.add(combinados4);

// creamos el arbol con la raiz y lo añadimos a la lamina
        JTree arbol = new JTree(golosinas);
        
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
