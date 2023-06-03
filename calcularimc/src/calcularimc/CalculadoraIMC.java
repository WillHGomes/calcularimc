package calcularimc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {
    private JTextField textFieldPeso;
    private JTextField textFieldAltura;
    private JLabel labelResultado;
    private JLabel labelClassificacao;

    public CalculadoraIMC() {
        // Configurações básicas da janela
        setTitle("Calculadora de IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Criação dos componentes da interface
        JLabel labelPeso = new JLabel("Peso (Kg):");
        JLabel labelAltura = new JLabel("Altura (Cm):");
        textFieldPeso = new JTextField(10);
        textFieldAltura = new JTextField(10);
        JButton buttonCalcular = new JButton("Calcular");
        labelResultado = new JLabel("");
        labelClassificacao = new JLabel("");

        // Adiciona os componentes ao painel
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(labelPeso);
        panel.add(textFieldPeso);
        panel.add(labelAltura);
        panel.add(textFieldAltura);
        panel.add(buttonCalcular);
        panel.add(new JLabel());
        panel.add(labelResultado);
        panel.add(labelClassificacao);

        // Define o comportamento do botão Calcular
        buttonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        // Adiciona o painel à janela
        add(panel);
    }

    private void calcularIMC() {
        // Obtém os valores de peso e altura digitados pelo usuário
        double peso = Double.parseDouble(textFieldPeso.getText());
        double altura = Double.parseDouble(textFieldAltura.getText()) / 100.0; // Converte altura para metros

        // Calcula o IMC
        double imc = peso / (altura * altura);

        // Exibe o resultado e a classificação
        labelResultado.setText("IMC: " + String.format("%.2f", imc));
        if (imc < 18.5) {
            labelClassificacao.setText("Classificação: Abaixo do peso");
        } else if (imc < 25) {
            labelClassificacao.setText("Classificação: Peso normal");
        } else if (imc < 30) {
            labelClassificacao.setText("Classificação: Sobrepeso");
        } else {
            labelClassificacao.setText("Classificação: Obeso");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraIMC().setVisible(true);
            }
        });
    }
}
