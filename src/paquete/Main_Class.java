//Andrés Villalobos
//11-3-22
package paquete;

import java.util.Scanner;

public class Main_Class {

    public static void main(String[] args) {
        //Variables
        int size;

        Scanner respuesta = new Scanner(System.in);

        System.out.println("---Generador de claves---");
        System.out.println("Ingrese el tamaño de la clave que desea generar automáticamente");
        size = respuesta.nextInt();

        char[] clave = new char[size];

        GenerarClave key = new GenerarClave();
        clave = key.unirCaracteres(clave, size);

        System.out.print("Su clave generada: ");
        for (char c : clave) {
            System.out.print(c);
        }
        System.out.println("");
    }

}
