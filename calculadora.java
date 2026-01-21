import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class calculadora extends JFrame implements ActionListener {

    JButton botao0;
    JButton botao1;
    JButton botao2;
    JButton botao3;
    JButton botao4;
    JButton botao5;
    JButton botao6;
    JButton botao7;
    JButton botao8;
    JButton botao9;

    JButton botaoSoma;
    JButton botaoSub;
    JButton botaoMul;
    JButton botaoDiv;

    JTextPane campoErro;
    JTextField campo1;
    JTextField campo2;
    JTextField lastCamp;

    /* Inicialização da Interface */
    public calculadora(String n) {
        super(n);

        JPanel painel = new JPanel();

        /* Campos */
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.X_AXIS));

        JPanel painelTelas = new JPanel();
        painelTelas.setLayout(new BoxLayout(painelTelas, BoxLayout.Y_AXIS));

        campoErro = new JTextPane();
        campoErro.setEditable(false);
        campoErro.setFocusable(false);

        campo1 = new JTextField(null);
        campo1.setPreferredSize(new Dimension(0, 50));
        campo1.addFocusListener(
                new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        lastCamp = campo1;
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                    }
                });

        campo2 = new JTextField(null);
        campo2.setPreferredSize(new Dimension(0, 50));
        campo2.addFocusListener(
                new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        lastCamp = campo2;
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                    }
                });
        lastCamp = campo1;
        painelCampos.add(campo1);
        painelCampos.add(campo2);

        painelTelas.add(campoErro);
        painelTelas.add(painelCampos);

        /* Botões de Numeros */

        botao1 = new JButton("1");
        botao1.setActionCommand("botao1");
        botao1.addActionListener(this);

        botao2 = new JButton("2");
        botao2.setActionCommand("botao2");
        botao2.addActionListener(this);

        botao3 = new JButton("3");
        botao3.setActionCommand("botao3");
        botao3.addActionListener(this);

        botao4 = new JButton("4");
        botao4.setActionCommand("botao4");
        botao4.addActionListener(this);

        botao5 = new JButton("5");
        botao5.setActionCommand("botao5");
        botao5.addActionListener(this);

        botao6 = new JButton("6");
        botao6.setActionCommand("botao6");
        botao6.addActionListener(this);

        botao7 = new JButton("7");
        botao7.setActionCommand("botao7");
        botao7.addActionListener(this);

        botao8 = new JButton("8");
        botao8.setActionCommand("botao8");
        botao8.addActionListener(this);

        botao9 = new JButton("9");
        botao9.setActionCommand("botao9");
        botao9.addActionListener(this);

        botao0 = new JButton("0");
        botao0.setActionCommand("botao0");
        botao0.addActionListener(this);

        /* Botões de Operadores */

        botaoSoma = new JButton("+");
        botaoSoma.setActionCommand("soma");
        botaoSoma.addActionListener(this);

        botaoSub = new JButton("-");
        botaoSub.setActionCommand("sub");
        botaoSub.addActionListener(this);

        botaoMul = new JButton("x");
        botaoMul.setActionCommand("multi");
        botaoMul.addActionListener(this);

        botaoDiv = new JButton("/");
        botaoDiv.setActionCommand("div");
        botaoDiv.addActionListener(this);

        /* Teclado */

        JPanel teclado = new JPanel();
        teclado.setLayout(new GridLayout(4, 4, 2, 2));

        teclado.add(botao1);
        teclado.add(botao2);
        teclado.add(botao3);
        teclado.add(botaoSoma);

        teclado.add(botao4);
        teclado.add(botao5);
        teclado.add(botao6);
        teclado.add(botaoSub);

        teclado.add(botao7);
        teclado.add(botao8);
        teclado.add(botao9);
        teclado.add(botaoMul);

        teclado.add(new JPanel());
        teclado.add(botao0);
        teclado.add(new JPanel());
        teclado.add(botaoDiv);

        /* Painel Principal */
        painel.setLayout(new BorderLayout(4, 4));

        painel.add(painelTelas, BorderLayout.NORTH);
        painel.add(teclado, BorderLayout.CENTER);

        getContentPane().add(painel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String target = event.getActionCommand();

            switch (target) {
                case "botao0" -> lastCamp.setText(lastCamp.getText() + "0");
                case "botao1" -> lastCamp.setText(lastCamp.getText() + "1");
                case "botao2" -> lastCamp.setText(lastCamp.getText() + "2");
                case "botao3" -> lastCamp.setText(lastCamp.getText() + "3");
                case "botao4" -> lastCamp.setText(lastCamp.getText() + "4");
                case "botao5" -> lastCamp.setText(lastCamp.getText() + "5");
                case "botao6" -> lastCamp.setText(lastCamp.getText() + "6");
                case "botao7" -> lastCamp.setText(lastCamp.getText() + "7");
                case "botao8" -> lastCamp.setText(lastCamp.getText() + "8");
                case "botao9" -> lastCamp.setText(lastCamp.getText() + "9");

                case "soma" -> soma(campo1, campo2);
                case "sub" -> subtracao(campo1, campo2);
                case "multi" -> multiplicacao(campo1, campo2);
                case "div" -> divisao(campo1, campo2);
            }
        } catch (ArithmeticException e) {
            campoErro.setText("Erro: Divisão por zero!");
            System.err.printf("Exception: %s\n", e);
        } catch (NumberFormatException e) {
            if (campo1.getText().isEmpty() || campo2.getText().isEmpty()) {
                campoErro.setText("Erro: Campo vazio!");
                System.err.printf("Exception: %s\n", e);
            } else {
                campoErro.setText("Erro: Digite um número!");
                System.err.printf("Exception: %s\n", e);
            }
        }

    }

    private void soma(JTextField tf1, JTextField tf2) {
        double x = Double.parseDouble(tf1.getText());
        double y = Double.parseDouble(tf2.getText());

        campo2.setText(String.valueOf(x + y));
        campoErro.setText("");
    }

    private void subtracao(JTextField tf1, JTextField tf2) {
        double x = Double.parseDouble(tf1.getText());
        double y = Double.parseDouble(tf2.getText());

        campo2.setText(String.valueOf(x - y));
        campoErro.setText("");
    }

    private void multiplicacao(JTextField tf1, JTextField tf2) {
        double x = Double.parseDouble(tf1.getText());
        double y = Double.parseDouble(tf2.getText());

        campo2.setText(String.valueOf(x * y));
        campoErro.setText("");
    }

    private void divisao(JTextField tf1, JTextField tf2) {
        double x = Double.parseDouble(tf1.getText());
        double y = Double.parseDouble(tf2.getText());

        if(y==0){
            throw new ArithmeticException("Divisão por zero");
        }

        campo2.setText(String.valueOf(x / y));
        campoErro.setText("");
    }

    public static void main(String[] args) {
        calculadora ca = new calculadora("Calculadora");
        ca.setSize(250, 400);
        ca.setVisible(true);
        ca.setResizable(false);
        ca.setAlwaysOnTop(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        ca.setLocation((screen.width / 2) - 125, (screen.height / 2) - 200);

    }
}