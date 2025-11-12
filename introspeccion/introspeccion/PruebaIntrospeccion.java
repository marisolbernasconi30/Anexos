package introspeccion;

import java.util.Scanner;
import java.lang.reflect.*;

public class PruebaIntrospeccion {

    public static void main(String[] args) {

Scanner entrada= new Scanner(System.in);
System.out.println("Introduce el nombre completo de la clase a instanciar ");
String nombreClase;
nombreClase=entrada.next();

//imprimir clase y superclase

try{

Class<?> clase= Class.forName(nombreClase);
Class<?> superC1= clase.getSuperclass(); //superclase 

System.out.println("Clase: " + nombreClase);


if(superC1 != null && superC1 != Object.class){
    System.out.println("Superclase: " + superC1.getName());
}else{
    System.out.println("La clase no tiene superclase");
}


System.out.println(); // esto es un salto de linea 

ImprimirContructores(clase); //es un metodo que va a imprimir los contructores 

System.out.println(); // esto es un salto de linea 

ImprimirMetodos(clase); //es un metodo que va a imprimir los metodos

System.out.println(); // esto es un salto de linea 

ImprimirCampos(clase); //es un metodo que va a imprimir los campos


   }catch(Exception e){
    e.printStackTrace();
    System.exit(0); 
   } 


  }

  public static void ImprimirContructores(Class<?> clase){
    System.out.println("Los constructores son: ");
    Constructor[] constructores= clase.getDeclaredConstructors();

    for(Constructor c: constructores){
      String nombre=c.getName(); //me devuelve el nombre del constructor que puede tener la clase 

      System.out.print("  " + Modifier.toString(c.getModifiers())) ; //me devuelve los modificadores del constructor
      System.out.print(" " + nombre + "("); //imprime el nombre del constructor

      //imprimir los parametros del constructor
      Class[] tiposParametros= c.getParameterTypes(); //creo la variable que me devuelve los tipos de parametros del constructor y me lo guarda en un array de tipo class
      for(int i=0; i<tiposParametros.length; i++){
        if(i>0){
          System.out.print(", "); //si hay mas de un parametro le pongo una coma
          System.out.print(tiposParametros[i].getName()); //me devuelve el nombre del tipo de parametro

        } // hasta aca, ya obtuvimos los parametros del constructor

        System.out.print(");"); //cierro el parentesis del constructor

}

}

}

}


