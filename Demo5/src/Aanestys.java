import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.SwingConstants;

/**
 * Pieni esimerkki ��nestys-ohjelmasta.
 * TODO: Poista switch-lause
 * <br>
 * Lis�teht�v� p��teohjauksen 5 aluksi:
 *<pre>
 * Teht�vi�:
 *   1)  Muuta ohjelma sellaiseksi, ett� se kysyy 
 *       Kyll�, Ei, En osaa sanoa tilalla
 *         Oletko Tytt�,Poika,Mies vaiko Nainen
 *       ja n�ytt�� sen j�lkeen sopivan ilmoituksen t�st�.
 *
 *   2)  Muuta ohjelmaa edelleen siten, ett� se ��nesystuloksen 
 *       ilmoituksen yhteydess� n�ytt�� montako 
 *       tytt��/poikaa/miest�/naista
 *       on vastattu t�h�n menness�. Rivinvaihdon showMessageDialog:iin
 *       saat tyyliin: 
 *          JOptionPane.showMessageDialog(null,"Olet siis tytt�\n" + 
 *             "Tytt�j�: " + t); 
 *</pre>
 *  
 * @author vesal
 * @version 6.2.2011
 */
public class Aanestys extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JLabel labelAihe = new JLabel("Oletko?");
    private final JPanel panelAanestys = new JPanel();
    private final JPanel panelValinta = new JPanel();
    private final JLabel lblValitse = new JLabel("Valitse");
    private final JRadioButton rb0 = new JRadioButton("Tytt\u00F6");
    private final JRadioButton rb1 = new JRadioButton("Poika");
    private final JRadioButton rb2 = new JRadioButton("Nainen");
    private final JRadioButton rb3 = new JRadioButton("Mies");
    private final JButton buttonAanesta = new JButton("\u00C4\u00E4nest\u00E4");
    private final Component verticalStrut = Box.createVerticalStrut(20);
    private final ButtonGroup groupAanestys = new ButtonGroup();
    public int[] tulos = new int[4];

    /**
     * Launch the application.
     * @param args Ei k�yt�ss�
     */
    public static void main(String[] args) {
    	
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Aanestys frame = new Aanestys();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public Aanestys() {
        setTitle("\u00C4\u00E4nestys");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 251, 271);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        labelAihe.setFont(new Font("Arial", Font.BOLD, 19));
        
        contentPane.add(labelAihe, BorderLayout.NORTH);
        contentPane.add(panelAanestys, BorderLayout.CENTER);
        panelAanestys.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelAanestys.setLayout(new BoxLayout(panelAanestys, BoxLayout.Y_AXIS));
        panelValinta.setToolTipText("Valitse \u00E4\u00E4nestett\u00E4v\u00E4 kohde");
        panelValinta.setFont(new Font("Arial", Font.BOLD, 15));
        panelValinta.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(10, 10, 10, 10)));
        
        panelAanestys.add(panelValinta);
        panelValinta.setLayout(new BoxLayout(panelValinta, BoxLayout.Y_AXIS));
        
        panelValinta.add(lblValitse);
        groupAanestys.add(rb0);
        rb0.setHorizontalAlignment(SwingConstants.TRAILING);
        rb0.setSelected(true);
        rb0.setMnemonic('K');
        
        panelValinta.add(rb0);
        groupAanestys.add(rb1);
        rb1.setMnemonic('E');
        
        panelValinta.add(rb1);
        groupAanestys.add(rb2);
        rb2.setMnemonic('O');
        
        panelValinta.add(rb2);
        
        panelValinta.add(rb3);
        groupAanestys.add(rb3);
        rb3.setMnemonic('V');
        panelAanestys.add(verticalStrut);
        buttonAanesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                aanesta(tulos);
                
            }
        });
        
        panelAanestys.add(buttonAanesta);
        getRootPane().setDefaultButton(buttonAanesta);
        



    }

    /// Omat aliohjelmat
    
    private JRadioButton[] buttons = {rb0,rb1,rb2,rb3};
    
     
    /**
     * ��nestet��n valittua kohdetta
     * @example
     * <pre name="test">
     * #import javax.swing.*;
     *   comtest.GUITester g = new comtest.GUITester();
     *   Aanestys frame = new Aanestys();
     *   g.showWindow(frame);
     *   JButton buttonAanesta = g.getComponent(JButton.class);
     *   g.click(buttonAanesta);
     *   JLabel l = g.getComponent(JLabel.class,g.where.textMatches("��nes.*"));
     *   l.getText() === "��nestit siis: Tytt�"; 
     * </pre>
     */
    protected void aanesta(int[] tulos) {
        String kohde = "";
        ButtonModel b = groupAanestys.getSelection();
        
        char nappain = (char)b.getMnemonic();
        switch (nappain) {
            case 'K': kohde = "Tytt�"; break;
            case 'E': kohde = "Poika"; break;
            case 'O': kohde = "Nainen"; break;
            case 'V': kohde = "Mies"; break;
        }
        
        tulos = aaniLaskin(kohde, tulos);

        
        JOptionPane.showMessageDialog(null,"Olet siis: " + kohde + "\nTilanne:\nTytt�: " + tulos[0] +"\nPoika: "+ tulos[1] +
        "\nNainen: "+ tulos[2] + "\nMies: "+ tulos[3]); 
        /**
        char nappain = (char)b.getMnemonic();
        if ( rb0.getMnemonic() == nappain ) kohde = rb0.getText(); 
        if ( rb1.getMnemonic() == nappain ) kohde = rb1.getText(); 
        if ( rb2.getMnemonic() == nappain ) kohde = rb2.getText();
        
        
        if ( rb0.getModel() == b ) kohde = rb0.getText(); 
        if ( rb1.getModel() == b ) kohde = rb1.getText(); 
        if ( rb2.getModel() == b ) kohde = rb2.getText();
         **/
        
        for ( JRadioButton rb : buttons ) 
            if ( rb.getModel() == b ) {
                kohde = rb.getText();
                break;
            }
        

        for (Enumeration<AbstractButton> rbs = groupAanestys.getElements(); rbs.hasMoreElements();) { 
            AbstractButton rb = rbs.nextElement();
            if ( rb.getModel() == b ) {
                kohde = rb.getText();
                break;
            }
     
        }


  	
 
        
        
    }


	private int[] aaniLaskin(String kohde,int[] tilanne) {
		// TODO Auto-generated method stub

		
		if(kohde.equals ("Tytt�"))tilanne[0]++;
		if(kohde.equals ("Poika"))tilanne[1]++;
		if(kohde.equals ("Nainen"))tilanne[2]++;
		if(kohde.equals ("Mies"))tilanne[3]++;
		return tilanne;

	}   
}
