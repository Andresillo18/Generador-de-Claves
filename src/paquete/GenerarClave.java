//Andrés Villalobos
//11-3-22
//math.random * numero
package paquete;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GenerarClave {

    //Atributos
    private int letrasMinusculas;
    private int letrasMayusculas;
    private int cantidadNum;
    private int cantidadSimbolos;
    private int sumaCaracteres;
    private int numero;
    private boolean aprovado = false;

    //Propiedades
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getLetrasMinusculas() {
        return letrasMinusculas;
    }

    public void setLetrasMinusculas(int letrasMinusculas) {
        this.letrasMinusculas = letrasMinusculas;
    }

    public int getLetrasMayusculas() {
        return letrasMayusculas;
    }

    public void setLetrasMayusculas(int letrasMayusculas) {
        this.letrasMayusculas = letrasMayusculas;
    }

    public int getCantidadNum() {
        return cantidadNum;
    }

    public void setCantidadNum(int cantidadNum) {
        this.cantidadNum = cantidadNum;
    }

    public int getCantidadSimbolos() {
        return cantidadSimbolos;
    }

    public void setCantidadSimbolos(int cantidadSimbolos) {
        this.cantidadSimbolos = cantidadSimbolos;
    }

    public int getSumaCaracteres() {
        return sumaCaracteres;
    }

    public void setSumaCaracteres(int sumaCaracteres) {
        this.sumaCaracteres = sumaCaracteres;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    //Constructor vacío
    public GenerarClave() {
    }

    //Método para generar la clave  
    public char[] unirCaracteres(char[] clave, int size) { // Al recibir un array debe incluirse los []

        Scanner respuesta = new Scanner(System.in);
        ThreadLocalRandom r = ThreadLocalRandom.current();

        do {

            System.out.println("Ahora ingrese la cantidad de letras Minúsculas que debe tener la clave");
            setLetrasMinusculas(respuesta.nextInt());

            System.out.println("Ahora ingrese la cantidad de letras Mayúsculas que debe tener la clave");
            setLetrasMayusculas(respuesta.nextInt());

            System.out.println("Ahora ingrese la cantidad de números que debe tener la clave");
            setCantidadNum(respuesta.nextInt());

            System.out.println("Ahora ingrese la cantidad de simbolos que debe tener la clave");
            setCantidadSimbolos(respuesta.nextInt());

            setSumaCaracteres(getLetrasMinusculas() + getLetrasMayusculas() + getCantidadNum() + getCantidadSimbolos());

            if (getSumaCaracteres() != size) {
                System.out.println("**La cantidad de caracteres especificados no son igual su largo de la contraseña, inténtelo de nuevo**");
                System.out.println("");
            } else {
                setAprovado(true);
            }

        } while (isAprovado() == false);

        //For para generar las letras minúsculas
        for (int i = 0; i < getLetrasMinusculas(); i++) {
            setNumero(r.nextInt(97, 122));
            clave[i] = (char) getNumero();
        }

        //For para generar las mayúsculas, empieza a ingresar al array de donde quedo con las minúsculas hasta la cantidad de minúsculas y mayúsculas
        for (int i = getLetrasMinusculas(); i < (getLetrasMinusculas() + getLetrasMayusculas()); i++) {
            setNumero(r.nextInt(65, 90));
            clave[i] = (char) getNumero();
        }

        //For para generar los números para la clave, lo recorre hasta la cantidad de minúsculas, mayúsculas y los números a generar por el usuario
        for (int i = (getLetrasMinusculas() + getLetrasMayusculas()); i < (size - getCantidadSimbolos()); i++) {
            setNumero(r.nextInt(48, 57));
            clave[i] = (char) getNumero();
        }

        for (int i = (size - getCantidadSimbolos()); i < size; i++) {
            setNumero(r.nextInt(33, 47));
            clave[i] = (char) getNumero();
        }

        return clave;
    }

}
