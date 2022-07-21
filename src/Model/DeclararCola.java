package Model;

/** @author Jose Ignacio */

public class DeclararCola {

    static final int cantidad_nodos = 10;
    private int totalNodos;
    private Nodo frente;
    private Nodo finalCola;

    public void DeclaraCola() {
        totalNodos = 0;
        frente = null;
        finalCola = null;
    }

    public int getTotalNodos() {
        return totalNodos;
    }

    public Nodo getFrente() {
        return frente;
    }

    public Nodo getFinal() {
        return finalCola;
    }

    public boolean colaLLena() {
        if (getTotalNodos() >= cantidad_nodos) {
            return true;
        } else {
            return false;
        }
    }

    public boolean colaVacia() {
        if (getTotalNodos() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar(String isbn, String nombrelib, String name, int id, String op, String fecha, int cant) {
        if (!colaLLena()) { 
            Nodo temp = new Nodo();
            temp.setIsbn(isbn);
            temp.setNombrelibro(nombrelib);
            temp.setNombreuser(name);
            temp.setId(id);
            temp.setOperacion(op);
            temp.setFecha(fecha);
            temp.setCantidad(cant);
            if (getFrente() == null) { 
                frente = temp;
            } else {
                getFinal(); 
            }
            finalCola = temp;
            totalNodos = totalNodos + 1; 
        }
    }


    public void quitar() {
        Nodo temp;
        if (!colaVacia()) { 
            temp = getFrente(); 
            frente = getFrente().getSiguiente(); 
            if (getFrente() == null) { 
                finalCola = null;
            }
            temp = null; 
            totalNodos = totalNodos - 1; 
        }
    }
 

    public Nodo valorFrente() {
        return getFrente();
    }


    public Nodo valorFinal() {
        return getFinal();
    }

    public void limpiarCola() {
        while (!colaVacia()) {
            quitar();
        }
    }
}

