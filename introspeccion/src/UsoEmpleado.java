package src;
public class UsoEmpleado { //con esta es con la que va a arrancar el sistema
    public static void main(String[] args) {
      Persona persona1 = new Persona("Juan", "Perez");
      System.out.println("El nombre de la persona es: " + persona1.getNombre() + " " + persona1.getApellido());

        Empleado empleado1 = new Empleado("Ana", "Gomez", 3000);    
        System.out.println("El nombre del empleado es: " + empleado1.getNombre() + " " + empleado1.getApellido());
        System.out.println(empleado1.getSalario());

       // System.out.println(persona1.getClass()); //DEVUELVE LA CLASE A LA QUE PERTENECE EL OBJETO (PRINCIPIO DE INTROSPECCION)
       // ESTE METODO NOS DEVUELVE UN OBJETO DE TIPO CLASS 

        //Class cl1=persona1.getClass(); //OBTENEMOS LA CLASE A LA QUE PERTENECE EL OBJETO persona1
        //System.out.println(cl1.getName()); //DEVUELVE EL NOMBRE DE LA CLASE (de la identidad) A LA QUE PERTENECE EL OBJETO persona1


        String nombreClasePersona="Persona"; //NOMBRE COMPLETO DE LA CLASE (CON PAQUETE INCLUIDO)
        try {
            Class<?> cl2 = Class.forName(nombreClasePersona); //OBTENEMOS LA CLASE A PARTIR DE SU NOMBRE COMPLETO
            System.out.println("Nombre de la clase obtenida: " + cl2.getName());
           
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}

class Persona{

    public Persona (String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
 
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private String nombre;
    private String apellido;
}  

  class Empleado extends Persona {
    public Empleado (String nombre, String apellido, double salario) {
        super(nombre, apellido); //llamamos al constructor de la clase padre
        this.salario = salario; //inicializamos el atributo salario
    }

   public void setIncentivo(double incentivo) {
        salario = salario +  incentivo; //aumentamos el salario en el incentivo
    }

    public String getSalario(){
        return "El salario es: " + salario;
    }

    private double salario;
  }
