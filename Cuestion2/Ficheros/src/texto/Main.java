package texto;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            // Crea objetos File para los archivos de preguntas y respuestas
            File archivoPreguntas = new File("preguntas.txt");
            File archivoRespuestas = new File("respuestas.txt");

            // Crea objetos Scanner para leer los archivos de preguntas y respuestas
            Scanner lectorPreguntas = new Scanner(archivoPreguntas);
            Scanner lectorRespuestas = new Scanner(archivoRespuestas);

            // Crea un objeto Scanner para leer la entrada del usuario
            Scanner lectorUsuario = new Scanner(System.in);

            // Inicializa la puntuación del usuario
            double puntuacion = 0;

            // Mientras haya más preguntas y respuestas en los archivos
            while (lectorPreguntas.hasNextLine() && lectorRespuestas.hasNextLine()) {
                // Lee la siguiente pregunta y respuesta
                String pregunta = lectorPreguntas.nextLine();
                String respuestaCorrecta = lectorRespuestas.nextLine();

                // Muestra la pregunta al usuario
                System.out.println(pregunta);

                // Lee la respuesta del usuario
                String respuestaUsuario = lectorUsuario.nextLine();

                // Si la respuesta del usuario es correcta, incrementa la puntuación
                if (respuestaUsuario.trim().equalsIgnoreCase(respuestaCorrecta.trim())) {
                    System.out.println("¡Correcto!");
                    puntuacion++;
                } else { // Si no, la disminuye
                    System.out.println("Incorrecto. La respuesta correcta era: " + respuestaCorrecta);
                    puntuacion -= 0.5;
                }
            }

            // Cierra los objetos Scanner
            lectorPreguntas.close();
            lectorRespuestas.close();
            lectorUsuario.close();

            // Muestra la puntuación final del usuario
            System.out.println("Has terminado el cuestionario. Tu puntuación es: " + puntuacion);

        } catch (FileNotFoundException e) {
            // Muestra un mensaje de error si no se pudo encontrar uno de los archivos
            System.out.println("Se produjo un error.");
            e.printStackTrace();
        }
    }
}