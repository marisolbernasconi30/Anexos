package introspeccion;

import java.util.Scanner;

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








}catch(Exception e){
    e.printStackTrace();

}
}
}

