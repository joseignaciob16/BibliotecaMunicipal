package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import View.Ventana;

/**@author Jose Ignacio */

public class ArchivoLibros {
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
    
   

    public void guardarArchivo(Libro lib) throws IOException {
        File archivo;
        archivo = new File("libros.txt");
        Ventana v = new Ventana();
        BufferedWriter escribir;
        if (archivo.exists()) {
            escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(lib.getIsbn() + "\t");
            escribir.write(lib.getNombre() + "\t");
            escribir.write(lib.getAutor() + "\t");
            escribir.write(lib.getCategoria() + "\t");
            escribir.write(lib.getEditorial() + "\t");
            escribir.write(convertir(lib.getPublicacion())+ "\t");
            escribir.write(convertir(lib.getCantidad()));
            escribir.newLine();
            } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
             escribir.newLine();
        }
        escribir.close(); 
    }

    public int contCategoria(String rutaArchivo, String categoria) throws FileNotFoundException, IOException {
        String linea = null;
        int contador = 0;
        Libro lib;
        FileReader fichero = new FileReader("Libros.txt");
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "\t");
            String isbn = campo.nextToken().trim();
            String nom = campo.nextToken().trim();
            String aut = campo.nextToken().trim();
            String cat = campo.nextToken().trim();
            String edi = campo.nextToken().trim();
            String pub = campo.nextToken().trim();
            String cant = campo.nextToken().trim();
            lib = new Libro();
            lib.setIsbn(isbn);
            lib.setNombre(nom);
            lib.setAutor(aut);
            lib.setCategoria(cat);
            lib.setEditorial(edi);
            lib.setPublicacion(Integer.parseInt(pub));
            lib.setCantidad(Integer.parseInt(cant));

            if (lib.getCategoria().equals(categoria)) {
                contador += lib.getCantidad();
            }
          
        }
        leer.close();
        return contador;
    }
    
  
}
