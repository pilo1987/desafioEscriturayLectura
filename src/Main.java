import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        crearArchivo("src/miDirectorio", "miArchivo.txt");

        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");

        escribirArchivo("src/miDirectorio/miArchivo.txt", lista);

        //Ingresar los datos de Busqueda//
        buscarTexto(" ", " ");
    }

    private static void crearArchivo(String nombreDirectorio, String nombreArchivo) {

        File directorio = new File(nombreDirectorio);
        if (!directorio.exists())
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado Exitosamente");
            } else {
                System.out.println("Error al crear Directorio");
                return;
            }
        else {
            System.out.println("El Directorio ya Existe");
        }

        File archivo = new File(directorio.getAbsolutePath() + "\\" + nombreArchivo);

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error en la creacion de archivo");
            e.printStackTrace();
        }
    }

    private static void escribirArchivo(String miArchivo, ArrayList<String> lista) {
        try {
            FileWriter fw = new FileWriter(miArchivo);
            BufferedWriter bw = new BufferedWriter(fw);

            Iterator<String> iterator = lista.iterator();
            while (iterator.hasNext()) {
                bw.write(iterator.next());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("error al escribir en el archivo");
            e.printStackTrace();
        }
    }

    private static void buscarTexto(String nombreArchivo, String texto) {
        File directorio = new File("src/miDirectorio");
        File archivo = new File(directorio, nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("El fichero ingresado NO existe");
            return;
        } else if (archivo.length() == 0) {
            System.out.println("El fichero ingresado está vacío");
            return;
        } else {
            System.out.println("El fichero ingresado existe");
            try {
                Scanner scanner = new Scanner(archivo);
                int count = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(texto)) {
                        count++;
                    }
                }
                scanner.close();
                System.out.println("Cantidad de repeticiones del texto -> " + count);
            } catch (IOException e) {
            }
        }
    }
}
