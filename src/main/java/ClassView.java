import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClassView extends JFrame{
    private JButton add = new JButton("Adunare");
    private JButton sub = new JButton("Scadere");
    private JButton div = new JButton("Impartire");
    private JButton multi = new JButton("Inmultire");
    private JButton deriv = new JButton("Derivare");
    private JButton integr = new JButton("Integrare");
    private JButton m_clearBtn = new JButton("Clear");
    private JTextField m_fieldPolinom1 = new JTextField(20);
    private JTextField m_fieldPolinom2 = new JTextField(20);
    private JTextField m_fieldResult1 = new JTextField(40);
    private JTextField m_fieldResult2 = new JTextField(20);
    private Polinom polin;


    ClassView(Polinom p1){
        polin = p1;

        Font f = new Font("TimesRoman",Font.BOLD,15);
        Font f1 = new Font("TimesRoman",Font.BOLD,20);
        Font f2 = new Font("TimesRoman",Font.ITALIC,15);
        Font f3 = new Font("TimesRoman",Font.BOLD,12);
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        JLabel label0 = new JLabel("!");
        label0.setFont(f1);
        label0.setForeground(Color.red);
        JLabel label = new JLabel("Vă rugăm să introduceți polinoamele după următorul format, începând cu gradul cel mai mare și terminând cu gradul cel mai mic: ");
        label.setFont(f3);
        label.setForeground(Color.white);
        JLabel l = new JLabel("''1.0*x^7+10.7*x^2+2.1''");
        l.setForeground(Color.gray);
        l.setFont(f2);
        panel0.add(label0);
        panel0.add(label);
        panel0.add(l);
        panel0.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Primul polinom: ");
        label1.setForeground(Color.white);
        label1.setFont(f);
        panel1.add(label1);
        panel1.add(m_fieldPolinom1);
        panel1.setLayout(new FlowLayout());

        JLabel label2 = new JLabel("Al doilea polinom: ");
        label2.setForeground(Color.white);
        label2.setFont(f);
        panel2.add(label2);
        panel2.add(m_fieldPolinom2);
        panel2.setLayout(new FlowLayout());

        panel3.add(add);
        panel3.add(sub);
        panel3.add(div);
        panel3.add(multi);
        panel3.add(deriv);
        panel3.add(integr);
        panel3.setLayout(new FlowLayout());

        JLabel label3 = new JLabel("Rezultat: ");
        label3.setForeground(Color.white);
        label3.setFont(f);
        panel4.add(label3);
        panel4.add(m_fieldResult1);
        m_fieldResult1.setOpaque(false);
        panel4.add(m_fieldResult2);
        m_fieldResult2.setOpaque(false);
        panel4.setLayout(new FlowLayout());

        m_fieldResult1.setEnabled(false);
        m_fieldResult2.setEnabled(false);

        panel5.add(m_clearBtn);
        panel5.setLayout(new FlowLayout());


        JPanel p = new JPanel();
        p.add(panel0);
        p.add(panel1);
        p.add(panel2);
        p.add(panel3);
        p.add(panel4);
        p.add(panel5);
        panel0.setBackground(Color.black);
        panel1.setBackground(Color.black);
        panel2.setBackground(Color.black);
        panel3.setBackground(Color.black);
        panel4.setBackground(Color.black);
        panel5.setBackground(Color.black);

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        //setSize(670,700);
        setPreferredSize(new Dimension(1000,400));
        this.setContentPane(p);
        this.pack();

        this.setTitle("Calculator de polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    void addSumListener(ActionListener aal){
        add.addActionListener(aal);
    }

    void addDifListener(ActionListener aal){
        sub.addActionListener(aal);
    }

    void addImpListener(ActionListener aal){ div.addActionListener(aal); }

    void addOriListener(ActionListener aal){
        multi.addActionListener(aal);
    }

    void addDerivListener(ActionListener aal){
        deriv.addActionListener(aal);
    }

    void addIntegrListener(ActionListener aal){
        integr.addActionListener(aal);
    }

    void setResult1(String result1){
        m_fieldResult1.setText(result1);
    }

    void setResult2(String result2){ m_fieldResult2.setText(result2); }

    void addClearListener(ActionListener cal) { m_clearBtn.addActionListener(cal); }


    String getUser1Input(){return m_fieldPolinom1.getText();}

    String getUser2Input(){return m_fieldPolinom2.getText();}

    void reset(){
        m_fieldPolinom1.setText(null);
        m_fieldPolinom2.setText(null);
        m_fieldResult1.setText(null);
        m_fieldResult2.setText(null);
    }

}
