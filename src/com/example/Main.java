package com.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {



        // Escribe el código que devuelva una cadena al revés
        String saludo = "Hola Mundo";
        for(int i = saludo.length()- 1; i >= 0; i--){
        System.out.print(saludo.charAt(i));
        }

        // Array unidimensional
        String[] cosas = new String[3];
        cosas[0] = "libro";
        cosas[1] = "plumon";
        cosas[2] = "borrador";

        for(int i = 0; i < cosas.length; i++){
            System.out.println("Nuestras cosas son: " + cosas[i]);
        }

        // Array bidimensional

        int[][] indices = new int[2][3];
        indices[0][0] = 40;
        indices[0][1] = 50;
        indices[0][2] = 60;


        indices[1][0] = 60;
        indices[1][1] = 70;
        indices[1][2] = 80;

        for(int i = 0; i < indices.length; i++){
            for(int j = 0; j < indices[i].length; j++){

                System.out.println("Fila: " + i + " Columna: " + j + " valor: " + indices[i][j] );

            }

        }

        // Vector

        Vector<Integer> numeros = new Vector<>();
        numeros.add(2);
        numeros.add(15);
        numeros.add(30);
        numeros.add(9);
        numeros.add(22);

        System.out.println(numeros);
        numeros.remove(1);
        numeros.remove(3);
        System.out.println(numeros);

        /*
         * El problema de usar un vector con la capacidad por defecto,
         * es que cuando haya un overflow, este se tendra que copiar y ampliar,
         * lo que provoca un problema computacional si se hace frecuentemente
         */


        // ArrayList tipo String
        ArrayList<String> cubiertos = new ArrayList<>();

        cubiertos.add("Tenedor");
        cubiertos.add("Cuchara");
        cubiertos.add("Cuchillo");
        cubiertos.add("Cucharon");

        for (String cubierto : cubiertos) {
            System.out.println("Estoy en un ArrayList: " + cubierto);
        }

        LinkedList<String> listaEnlazada = new LinkedList<>(cubiertos);
        for (String lista : listaEnlazada) {
            System.out.println("Estoy en una LinkedList: " + lista);
        }

        // ArrayList tipo Integer
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < numbers.size(); i++) {
            int numero = numbers.get(i);
            if(numero % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        for (Integer number : numbers) {
            System.out.println(number);
        }


    }
    // Funcion Divide por cero
    public static void DividePorCero(int A,int B) throws ArithmeticException {
        int resultado = 0;
        try {
            resultado = A/B;
        } catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        } catch (Exception E){
            System.out.println("Demo de codigo");
        }

    }

    // InputStream   PrintStream
    public class FileCopy {
        public static void copy(String fileIn, String fileOut) throws IOException {
            InputStream inputStream = null;
            PrintStream outputStream = null;
            try {
                // Abrimos los archivos de entrada y salida
                inputStream = new FileInputStream(fileIn);
                outputStream = new PrintStream(new FileOutputStream(fileOut));
                // Copiamos los datos
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            } finally {
                // Cerramos los archivos de entrada y salida
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }


}
