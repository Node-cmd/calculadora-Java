import java.awt.BorderLayout;
import java.awt.GridLayout;
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

    JTextField campo1;
    JTextField campo2;
    JTextField lastCamp;

    public calculadora(String n) {
        super(n);

        JPanel painel = new JPanel();

        /* Campos */
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.X_AXIS));

        campo1 = new JTextField(null);
        campo1.addFocusListener(
        new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                lastCamp = campo1;
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        campo2 = new JTextField(null);
        campo2.addFocusListener(
            new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                lastCamp = campo2;
            }
            
            @Override
            public void focusLost(FocusEvent e){
            }
            }
        );

        painelCampos.add(campo1);
        painelCampos.add(campo2);

        /* Numeros */
        JPanel painelNumeros2 = new JPanel();
        painelNumeros2.setLayout(new BorderLayout());

        JPanel painelNumeros = new JPanel();
        painelNumeros.setLayout(new GridLayout(3, 3,2,2));

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
        painelOperadores.setLayout(new GridLayout(4, 1,2,2));

        botaoSoma = new JButton("+");
        botaoSoma.setActionCommand("soma");

        botaoSub = new JButton("-");
        botaoSub.setActionCommand("sub");

        botaoMul = new JButton("x");
        botaoMul.setActionCommand("multi");

        botaoDiv = new JButton("/");
        botaoDiv.setActionCommand("div");


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

       
        
        painel.setLayout(new BorderLayout(4,4));

        painel.add(painelCampos, BorderLayout.NORTH);
        painel.add(teclado, BorderLayout.CENTER);
        

        getContentPane().add(painel);        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String target = event.getActionCommand();

        switch(target){
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
            
            case "soma" -> {
                int x = Integer.parseInt(campo1.getText());
                int y = Integer.parseInt(campo2.getText());
                campo2.setText(String.valueOf(x+y));
            }
            case "sub" -> {
                int x = Integer.parseInt(campo1.getText());
                int y = Integer.parseInt(campo2.getText());
                campo2.setText(String.valueOf(x - y));
            }
            case "multi" -> {
                int x = Integer.parseInt(campo1.getText());
                int y = Integer.parseInt(campo2.getText());
                campo2.setText(String.valueOf(x * y));
            }
            case "div" -> {
                int x = Integer.parseInt(campo1.getText());
                int y = Integer.parseInt(campo2.getText());
                if (y != 0) {
                    campo2.setText(String.valueOf(x / y));
                } else {
                    campo2.setText("Erro: Divisão por zero");
                }
            }
        }
        
    }


    public static void main(String[] args) {
        calculadora ca = new calculadora("Calculadora");
        ca.setSize(250, 400);
        ca.setVisible(true);
        ca.setAlwaysOnTop(true);

    }
}