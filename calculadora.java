import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

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
    JTextField campo1;
    JTextField campo2;

    public calculadora(String n) {
        super(n);

        JPanel painel = new JPanel();

        /* Campos */
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(1, 2));

        JTextField campo1 = new JTextField(null);
        JTextField campo2 = new JTextField(null);

        painelCampos.add(campo1);
        painelCampos.add(campo2);

        /* Numeros */
        JPanel painelNumeros2 = new JPanel();
        painelNumeros2.setLayout(new BorderLayout());

        JPanel painelNumeros = new JPanel();
        painelNumeros.setLayout(new GridLayout(3, 3));

        JButton botao1 = new JButton("1");
        JButton botao2 = new JButton("2");
        JButton botao3 = new JButton("3");
        JButton botao4 = new JButton("4");
        JButton botao5 = new JButton("5");
        JButton botao6 = new JButton("6");
        JButton botao7 = new JButton("7");
        JButton botao8 = new JButton("8");
        JButton botao9 = new JButton("9");
        JButton botao0 = new JButton("0");

        botao1.addActionListener(this);
        botao2.addActionListener(this);
        botao3.addActionListener(this);
        botao4.addActionListener(this);
        botao5.addActionListener(this);
        botao6.addActionListener(this);
        botao7.addActionListener(this);
        botao8.addActionListener(this);
        botao9.addActionListener(this);
        botao0.addActionListener(this);

        painelNumeros.add(botao1);
        painelNumeros.add(botao2);
        painelNumeros.add(botao3);
        painelNumeros.add(botao4);
        painelNumeros.add(botao5);
        painelNumeros.add(botao6);
        painelNumeros.add(botao7);
        painelNumeros.add(botao8);
        painelNumeros.add(botao9);

        painelNumeros2.add(painelNumeros, BorderLayout.CENTER);
        painelNumeros2.add(botao0, BorderLayout.SOUTH);

        /* Operadores */

        JPanel painelOperadores = new JPanel();
        painelOperadores.setLayout(new GridLayout(4, 1));

        JButton botaoSoma = new JButton("+");
        JButton botaoSub = new JButton("-");
        JButton botaoMul = new JButton("x");
        JButton botaoDiv = new JButton("/");

        botaoSoma.addActionListener(this);
        botaoSub.addActionListener(this);
        botaoMul.addActionListener(this);
        botaoDiv.addActionListener(this);

        painelOperadores.add(botaoSoma);
        painelOperadores.add(botaoSub);
        painelOperadores.add(botaoMul);
        painelOperadores.add(botaoDiv);

        /* */
        JPanel teclado = new JPanel();
        teclado.setLayout(new BorderLayout());
        teclado.add(painelNumeros2, BorderLayout.CENTER);
        teclado.add(painelOperadores, BorderLayout.EAST);

        /* */
        painel.setLayout(new BorderLayout());

        painel.add(painelCampos, BorderLayout.NORTH);
        painel.add(teclado, BorderLayout.CENTER);

        getContentPane().add(painel);
    }

    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource();

        if (target == botao0) {
            campo1.setText(campo1.getText() + "0");
        }
        if (target == botao1) {
            campo1.setText(campo1.getText() + "1");
        }
        if (target == botao2) {
            campo1.setText(campo1.getText() + "2");
        }
        if (target == botao3) {
            campo1.setText(campo1.getText() + "3");
        }
        if (target == botao4) {
            campo1.setText(campo1.getText() + "4");
        }
        if (target == botao5) {
            campo1.setText(campo1.getText() + "5");
        }
        if (target == botao6) {
            campo1.setText(campo1.getText() + "6");
        }
        if (target == botao7) {
            campo1.setText(campo1.getText() + "7");
        }
        if (target == botao8) {
            campo1.setText(campo1.getText() + "8");
        }
        if (target == botao9) {
            campo1.setText(campo1.getText() + "9");
        }
        if (target == botaoSoma) {

        }
        if (target == botaoSub) {
        }
        if (target == botaoMul) {
        }
        if (target == botaoDiv) {
        }

    }

    public static void main(String[] args) {
        calculadora ca = new calculadora("Calculadora");
        ca.setSize(400, 200);
        ca.setVisible(true);

    }
}