import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaLinealGUI {
    private JPanel pGeneral;
    private JTextField txtIngreso;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnMostrar;
    private JTextArea txtResultado;

    ListaLineal lista = new ListaLineal();

    //Main para crear y mostrar la interfaz
    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaLinealGUI");
        frame.setContentPane(new BusquedaLinealGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    //Se encarga de que los botones interactuen con la lista
    public BusquedaLinealGUI() {

        //Ejecuta la función de agregar los elementos ingresados por el usuario a la lista
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtIngreso.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor, txtResultado);
                    txtIngreso.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido.");
                }
            }
        });

        //Ejecuta la función eliminar un elemento de la lista por medio de un botón
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtIngreso.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.eliminar(valor, txtResultado);
                    txtIngreso.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido.");
                }
            }
        });

        //Ejecutar por medio de un botón la función de buscar y ver en que posición está un elemento
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtIngreso.getText();
                try {
                    int valor = Integer.parseInt(input);
                    int posicion = lista.buscarLineal(valor);
                    if (posicion == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento " + valor + " encontrado en la posición " + posicion);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido.");
                }
            }
        });

        //Botón que ejecuta la función de mostrar los elementos en txtResultado
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.mostrarLista(txtResultado);
            }
        });
    }
}
