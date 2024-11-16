import javax.swing.*;

public class ListaLineal {
    public Nodo inicio;
    public int tamano;

    //Se inicializa una lista vacía.
    public ListaLineal() {
        inicio = null;
        tamano = 0;
    }

    //Se agrega un nuevo nodo con el último dato que le damos a la lista
    public void agregar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);

        //Verificar si la lista está vacía
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            //Recorre la lista hasta el último nodo
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        actualizarLista(textArea);
    }

    //Elimina el nodo con el dato que le especificamos
    public boolean eliminar(int dato, JTextArea textArea) {

        //Comprobar si la lista está vacía
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return false;
        }

        //Verifica si el dato a eliminar está en el primer nodo
        if (inicio.dato == dato) {
            inicio = inicio.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }

        Nodo actual = inicio;

        //Busca el nodo que contiene el dato a eliminar
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }

        //Ayuda a comprobar si se encontró el nodo con el dato a eliminar
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }

        JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
        //Retorna falso si no se encontró el dato que se solicitaba
        return false;
    }

    //Busca un elemento de la lista y nos dice su posición
    public int buscarLineal(int dato) {
        Nodo actual = inicio;
        int posicion = 0;

        //Recorre la lista a través de un while
        while (actual != null) {

            //Verifica si el dato del nodo actual es el mismo que el que se busca
            if (actual.dato == dato) {
                return posicion +1;
            }
            actual = actual.siguiente;
            posicion++;
        }
        //Retorna -1 en caso de que no encontrara el dato en la lista
        return -1;
    }

    //Se usa para mostrar los elementos de la lista en un JTextArea
    public void mostrarLista(JTextArea textArea) {

        //Comprueba si la lista está vacía
        if (inicio == null) {
            textArea.setText("Lista vacía");
        } else {
            StringBuilder listaStr = new StringBuilder("Elementos de la lista:\n");
            Nodo actual = inicio;

            //Recorremos la lista nodo por nodo
            while (actual != null) {
                listaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }

    //Actualizamos la lista en el JTextArea
    public void actualizarLista(JTextArea textArea) {
        mostrarLista(textArea);
    }
}

