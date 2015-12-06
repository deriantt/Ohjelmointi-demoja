import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import fi.jyu.mit.ohj2.*;

public class KayttoLiittymaT1 extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Kerron sinulle paljonko t\u00E4yt\u00E4t t\u00E4n\u00E4 vuonna!");
	private final JLabel lblSyntymvuotesi = new JLabel("Syntym\u00E4vuotesi");
	private final JTextField textSyntymaVuosi = new JTextField();
	private final JTextField textIkaTanaVuonna = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayttoLiittymaT1 frame = new KayttoLiittymaT1();
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
	public KayttoLiittymaT1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_lblSyntymvuotesi = new GridBagConstraints();
		gbc_lblSyntymvuotesi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSyntymvuotesi.gridx = 1;
		gbc_lblSyntymvuotesi.gridy = 4;
		contentPane.add(lblSyntymvuotesi, gbc_lblSyntymvuotesi);
		textSyntymaVuosi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				laske();
			}
		});
		textSyntymaVuosi.setText("1988");
		textSyntymaVuosi.setColumns(10);
		
		GridBagConstraints gbc_textSyntymaVuosi = new GridBagConstraints();
		gbc_textSyntymaVuosi.insets = new Insets(0, 0, 5, 5);
		gbc_textSyntymaVuosi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSyntymaVuosi.gridx = 2;
		gbc_textSyntymaVuosi.gridy = 4;
		contentPane.add(textSyntymaVuosi, gbc_textSyntymaVuosi);
		textIkaTanaVuonna.setEditable(false);
		textIkaTanaVuonna.setColumns(10);
		
		GridBagConstraints gbc_textIkaTanaVuonna = new GridBagConstraints();
		gbc_textIkaTanaVuonna.insets = new Insets(0, 0, 0, 5);
		gbc_textIkaTanaVuonna.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIkaTanaVuonna.gridx = 2;
		gbc_textIkaTanaVuonna.gridy = 5;
		contentPane.add(textIkaTanaVuonna, gbc_textIkaTanaVuonna);
	}
//=====================================================================================================================
	/** Oletusvuosi*/
	public static final int TamaVuosi = 2013;
	
	protected void laske(){
		int syntymavuosi;
		int ika = 0;
		syntymavuosi = haeLuku(textSyntymaVuosi, 0);
		ika = TamaVuosi - syntymavuosi;
		laitaTulos(textIkaTanaVuonna, ika);
		
	}
	
	public static int haeLuku(JTextField text, int oletus){
		String jono = text.getText();
		int luku = Mjonot.erotaInt(jono , oletus);
		return luku;
	}
	
	public static void laitaTulos(JTextField text, int luku){
		String tulos = new String ("Täytät tänä vuonna " + luku + " vuotta.");
		text.setText(tulos);
	}

}
