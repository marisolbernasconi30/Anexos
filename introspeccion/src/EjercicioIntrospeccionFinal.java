package src;

import java.util.Scanner;
import java.lang.reflect.*;


public class EjercicioIntrospeccionFinal {

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

} //cierro el main


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

      } //cierro el for  que imprime los parametros 

     } // cierro el for que imprime los constructores


  } //cierro el metodo ImprimirConstructores


    public static void ImprimirMetodos(Class<?> clase) { //metodo para imprimir los metodos de cada clase
       
    Method [] metodos= clase.getDeclaredMethods(); //me devuelve un array de metodos de la clase
    for (Method m: metodos){
      Class tipoRetorno= m.getReturnType(); //me devuelve el tipo de retorno del metodo
        String nombre= m.getName(); //me devuelve el nombre del metodo

      System.out.print("  " + Modifier.toString(m.getModifiers())); //me devuelve los modificadores del metodo
      System.out.print(" " + tipoRetorno.getName() + " " + nombre + "("); //me devuelve el tipo de retorno del metodo y el nombre del metodo

      //imprimir los tipos de parametros del metodo
      Class[] tiposParametros= m.getParameterTypes(); //creo la variable que me devuelve los tipos de parametros del metodo y me lo guarda en un array de tipo class
      for(int i=0; i<tiposParametros.length; i++){
        if(i>0){
          System.out.print(", "); //si hay mas de un parametro le pongo una coma
          System.out.print(tiposParametros[i].getName()); //me devuelve el nombre del tipo de parametro

        } // hasta aca, ya obtuvimos los parametros del metodo

        System.out.print(");"); //cierro el parentesis del metodo

      } //cierro el for  que imprime los parametros 

     } // cierro el for que imprime los metodos
    }



    public static void ImprimirCampos(Class<?> clase) { //metodo para imprimir los campos de cada clase
           Field[] campos= clase.getDeclaredFields(); //me devuelve un array de campos de la clase
    for (Field f: campos){
      Class tipoCampo= f.getType(); //me devuelve el tipo del campo de clase
        String nombre= f.getName(); //me devuelve el nombre del campo de clase
    
    System.out.print("  " + Modifier.toString(f.getModifiers())); //me devuelve los modificadores del campo
    System.out.print(" " + tipoCampo.getName() + " " + nombre + ";"); //me devuelve el tipo del campo y el nombre del campo


    }
  

}

}


/*
 *
 * 


# estar en ANEXO/introspeccion

cd /home/marisol/eclipse-workspace/PROYECTO/Anexo/introspeccion

# compilar (y colocar .class en carpeta out para evitar confusiones)
javac -d out src/EjercicioIntrospeccionFinal.java

# ejecutar usando el nombre totalmente calificado (package + clase)
java -cp out src.EjercicioIntrospeccionFinal



 */

