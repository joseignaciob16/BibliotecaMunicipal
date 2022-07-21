package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/** @author Jose Ignacio */

public class ArchivoHistorial {
    private String rutaArchivo; 
    File archivo;

    public void Archivo() { 
        rutaArchivo = "";
    }

    public void setRutaArchivo(String nom) { 
        rutaArchivo = nom;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }


    public String convertir(int dato) {
        return String.valueOf(dato);
    }


    public void guardarArchivo(String isbn, String libro, String nombre,int id, String operacion, String fecha, int cant) throws IOException {
        File archivo;
        archivo = new File("Historial.txt");
        BufferedWriter escribir;
        if (archivo.exists()) {
            escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(isbn + "\t");
            escribir.write(libro + "\t");
            escribir.write(nombre + "\t");
            escribir.write(convertir(id) + "\t");
            escribir.write(operacion + "\t");
            escribir.write(fecha + "\t");
            escribir.write(convertir(cant));
            escribir.newLine();
            } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
             escribir.newLine();
        }
        escribir.close();   
    }
    
    public boolean ComprobodarDisponibilidad(String code) throws FileNotFoundException, IOException {
        String linea = null;
        boolean validacion = false;
        Nodo no;
        FileReader fichero = new FileReader("Historial.txt");
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "\t");
             String isbn = campo.nextToken().trim();
            String nomlibro = campo.nextToken().trim();
            String nomuser = campo.nextToken().trim();
            String id = campo.nextToken().trim();
            String operacion = campo.nextToken().trim();
            String fecha = campo.nextToken().trim();
            no = new Nodo();
            no.setIsbn(isbn);

            if (no.getIsbn().equals(code)) {

                if (operacion.equals("Prestamo")) {
                    validacion = true;
                } else {
                    validacion = false;
                }
            }
        }
        leer.close();
        return validacion;
    }
    
   
 }
