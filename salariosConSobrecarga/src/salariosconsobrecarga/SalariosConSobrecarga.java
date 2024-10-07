//EJERCICIO
//Se desea calcular el salario de un conjunto de empleados que tiene diferentes tipos de contratos asi:
// - A termino indefinido, tiene todas las prestaciones
// - Prestacion de servicios, no tiene prestacion alguna y debe pagar un descuento (porcentaje) que se ingresa 
//a traves del teclado
// - Salario integral, debe ganar almenos 10 salarios minimos y el empleado se  encarga de pagar
//sus prestaciones, ademas se le descuenta un impuesto que se ingresa por teclado (porcentaje)
//NOTA: A cada empleado se le debe ingresar el numero de horas trabajadas y el valor de la hora
package salariosconsobrecarga;
import java.text.DecimalFormat;
import java.util.Scanner;
public class SalariosConSobrecarga {

    //Definicion de objetos y variables
     public static Scanner teclado = new Scanner (System.in);
     public static float val_hora, sal_neto;
     public static int  nro_horas, opcion;
    
     private static void Pedir_datos(){
        System.out.print("Ingrese cuantas horas trabaja al mes?: ");
        nro_horas = teclado.nextInt();
        System.out.print("Cual es el valor de la hora?: ");
        val_hora = teclado.nextFloat();
        
    }

    public static void main(String[] args) {
        Clssalario clssalario = new Clssalario();
        DecimalFormat formato = new DecimalFormat ("#,###.#");
        double porc_retencion;
        float descuento;
        do{
            System.out.println("\n\t Menu Opciones Slario");
            System.out.println("1. Salario con prestaciones");
            System.out.println("2. Salario por prestaciones de servicios");
            System.out.println("3. Salario integral");
            System.out.println("4. Salir");
            System.out.print("Seleccione entre 1 y 4: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:Pedir_datos();
                    sal_neto = clssalario.calcular_salario_neto(nro_horas, val_hora);
                    System.out.println("\n\t El salario neto con prestaciones es " + sal_neto);
                    break;
                case 2:Pedir_datos();
                    System.out.print("Ingrese cual es el porcentaje del decuento: ");
                    descuento = teclado.nextFloat();
                    sal_neto=clssalario.calcular_salario_neto(nro_horas, val_hora, sal_neto);
                    System.out.println("\n El salario neto por prestacion de servicios es: " + sal_neto);
                    break;
                case 3:Pedir_datos();
                    if(nro_horas * val_hora >= 13000000){
                        System.out.print("Cual es el porcentaje de retencion" + " en la fuente?: ");
                        porc_retencion=teclado.nextDouble();
                        sal_neto=clssalario.calcular_salario_neto(nro_horas, val_hora, porc_retencion);
                        System.out.println("\n El salario integral es " + formato.format (sal_neto));
                    }else{
                         System.out.println("\n No gana lo suficiente para ser salario integral");
                    }
                    break;
            }
        }while(opcion !=4);
    }
    
       
    
}
