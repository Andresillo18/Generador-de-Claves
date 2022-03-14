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

        boolean noRepetido = true;
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
            do {
                setNumero(r.nextInt(97, 122));
                for (int j = 0; j < getLetrasMinusculas(); j++) {
                    if (clave[j] == (char) getNumero()) { //pregunta por cada index en el array si algún número generado se repite
                        noRepetido = false;
                        break; // Si hay uno que se repite se sale del for para que genere otro número random
                    } else {
                        noRepetido = true;
                    }
                }
            } while (noRepetido == false); // Se sale hasta que no se repita

            clave[i] = (char) getNumero(); // Se agrega si todo salió correctamente
        }

        //For para generar las mayúsculas, empieza a ingresar al array de donde quedo con las minúsculas hasta la cantidad de minúsculas y mayúsculas
        for (int i = getLetrasMinusculas(); i < (getLetrasMinusculas() + getLetrasMayusculas()); i++) {

            noRepetido = true;
            do {
                setNumero(r.nextInt(65, 90));
                for (int j = getLetrasMinusculas(); j < (getLetrasMinusculas() + getLetrasMayusculas()); j++) {
                    if (clave[j] == (char) getNumero()) { //pregunta por cada index en el array si algún número generado se repite
                        noRepetido = false;
                        break; // Si hay uno que se repite se sale del for para que genere otro número random
                    } else {
                        noRepetido = true;
                    }
                }
            } while (noRepetido == false); // Se sale hasta que no se repita

            clave[i] = (char) getNumero();
        }

        //For para generar los números para la clave, lo recorre hasta la cantidad de minúsculas, mayúsculas y los números a generar por el usuario
        for (int i = (getLetrasMinusculas() + getLetrasMayusculas()); i < (size - getCantidadSimbolos()); i++) {

            noRepetido = true;
            do {
                setNumero(r.nextInt(48, 57));
                for (int j = (getLetrasMinusculas() + getLetrasMayusculas()); j < (size - getCantidadSimbolos()); j++) {
                    if (clave[j] == (char) getNumero()) { //pregunta por cada index en el array si algún número generado se repite
                        noRepetido = false;
                        break; // Si hay uno que se repite se sale del for para que genere otro número random
                    } else {
                        noRepetido = true;
                    }
                }
            } while (noRepetido == false); // Se sale hasta que no se repita

            clave[i] = (char) getNumero();
        }

        //For para los simbolos
        for (int i = (size - getCantidadSimbolos()); i < size; i++) {

            noRepetido = true;
            do {
                setNumero(r.nextInt(33, 47));
                for (int j = (size - getCantidadSimbolos()); j < size; j++) {
                    if (clave[j] == (char) getNumero()) { //pregunta por cada index en el array si algún número generado se repite
                        noRepetido = false;
                        break; // Si hay uno que se repite se sale del for para que genere otro número random
                    } else {
                        noRepetido = true;
                    }
                }
            } while (noRepetido == false); // Se sale hasta que no se repita

            clave[i] = (char) getNumero();
        }

        return clave;
    }

}
