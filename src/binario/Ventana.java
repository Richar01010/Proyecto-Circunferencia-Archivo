package binario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {

    JLabel textDesimal, textBinario;
    JTextField formularioDescimal, formularioBinario;
    JButton botonBinario, botonRestaurar;
    GridBagConstraints gridBagConstraints;
    Container container;

    // Constructor de la clase Ventana
    public Ventana() throws Exception {
        super("Convertidor a Binario");
        this.setSize(250, 120); // Establece el tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permite cerrar la ventana
        this.setResizable(false); // Deshabilita la redimensión de la ventana
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        container = getContentPane();
        container.setLayout(new GridBagLayout()); // Usa GridBagLayout para el diseño
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(3, 3, 0, 0); // Establece márgenes entre componentes

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        // Línea 0: Etiqueta y campo de texto para el número decimal
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        textDesimal = new JLabel("Descimal : "); // Etiqueta para número decimal
        container.add(textDesimal, gridBagConstraints);
        formularioDescimal = new JTextField("0", 10); // Campo de texto para número decimal
        formularioDescimal.selectAll(); // Selecciona todo el texto por defecto

        gridBagConstraints.gridx = 1;
        container.add(formularioDescimal, gridBagConstraints);

        // Línea 1: Etiqueta y campo de texto para el número binario
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;

        textBinario = new JLabel("Binario : "); // Etiqueta para número binario
        container.add(textBinario, gridBagConstraints);
        formularioBinario = new JTextField(10); // Campo de texto para número binario
        formularioBinario.setEnabled(false); // Deshabilita la edición del campo binario

        gridBagConstraints.gridx = 1;
        container.add(formularioBinario, gridBagConstraints);

        // Línea 2: Botones para convertir y restaurar
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        botonBinario = new JButton("A Binario"); // Botón para convertir a binario
        container.add(botonBinario, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        botonRestaurar = new JButton("Restaurar"); // Botón para restaurar valores
        container.add(botonRestaurar, gridBagConstraints);

        // Acción del botón de conversión a binario
        botonBinario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int descimal = Integer.parseInt(formularioDescimal.getText()); // Obtiene número decimal del campo de
                                                                               // texto
                String binario = "";
                while (descimal > 0) { // Mientras el número decimal sea mayor a 0
                    int digito = descimal % 2; // Obtiene el bit menos significativo
                    binario = digito + binario; // Añade el bit a la cadena binaria
                    descimal /= 2; // Divide el número decimal por 2
                }
                formularioBinario.setText(binario); // Muestra el resultado en el campo binario
            }
        });

        // Acción del botón de restaurar
        botonRestaurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioDescimal.setText("0"); // Restaura el campo decimal a "0"
                formularioBinario.setText(""); // Limpia el campo binario
                formularioDescimal.requestFocus(); // Enfoca el campo decimal
            }
        });

        // Acción del campo de texto decimal al presionar Enter
        formularioDescimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioDescimal.selectAll(); // Selecciona todo el texto en el campo
            }
        });
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) throws Exception {
        Ventana ventana = new Ventana();
        ventana.setVisible(true); // Hace visible la ventana
    }
}
