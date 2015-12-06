import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;

import fi.jyu.mit.ohj2.Mjonot;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Ohjelma jolla lasketaan k‰ytt‰j‰n ik‰vuosi
 * @author Deniz
 *
 */

public class KayttoLiittyma extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblMittakaava = new JLabel("Mittakaava");
	private final JLabel lblSuhde = new JLabel("1:");
	private final JTextField textMittakaava = new JTextField();
	private final JLabel lblMatka = new JLabel("Kartalta mitattu matka");
	private final JTextField textKartalta = new JTextField();
	private final JLabel lblmm = new JLabel("mm.");
	private final JLabel lblMatkaMaastossa = new JLabel("Matka maastossa");
	private final JTextField textMaastossa = new JTextField();
	private final JLabel lblkm = new JLabel("km.");
	private final JLabel lblTyhja = new JLabel("");

	/**
	 * Launch the application.
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
					KayttoLiittyma frame = new KayttoLiittyma();
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
	public KayttoLiittyma() {
		textMaastossa.setColumns(10);
		textKartalta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				vaihda();
			}
		});
		textKartalta.setColumns(10);
		textMittakaava.setText("200000");
		textMittakaava.setToolTipText("Laita t\u00E4h\u00E4n synnyinvuotesi");
		textMittakaava.setColumns(10);
		setTitle("Mittakaava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_lblTyhja = new GridBagConstraints();
		gbc_lblTyhja.insets = new Insets(0, 0, 5, 5);
		gbc_lblTyhja.gridx = 1;
		gbc_lblTyhja.gridy = 0;
		contentPane.add(lblTyhja, gbc_lblTyhja);
		
		GridBagConstraints gbc_lblMittakaava = new GridBagConstraints();
		gbc_lblMittakaava.anchor = GridBagConstraints.EAST;
		gbc_lblMittakaava.insets = new Insets(0, 0, 5, 5);
		gbc_lblMittakaava.gridx = 1;
		gbc_lblMittakaava.gridy = 1;
		contentPane.add(lblMittakaava, gbc_lblMittakaava);
		
		GridBagConstraints gbc_lblSuhde = new GridBagConstraints();
		gbc_lblSuhde.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuhde.anchor = GridBagConstraints.EAST;
		gbc_lblSuhde.gridx = 2;
		gbc_lblSuhde.gridy = 1;
		contentPane.add(lblSuhde, gbc_lblSuhde);
		
		GridBagConstraints gbc_textMittakaava = new GridBagConstraints();
		gbc_textMittakaava.insets = new Insets(0, 0, 5, 5);
		gbc_textMittakaava.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMittakaava.gridx = 3;
		gbc_textMittakaava.gridy = 1;
		contentPane.add(textMittakaava, gbc_textMittakaava);
		
		GridBagConstraints gbc_lblMatka = new GridBagConstraints();
		gbc_lblMatka.anchor = GridBagConstraints.EAST;
		gbc_lblMatka.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatka.gridx = 1;
		gbc_lblMatka.gridy = 2;
		contentPane.add(lblMatka, gbc_lblMatka);
		
		GridBagConstraints gbc_textKartalta = new GridBagConstraints();
		gbc_textKartalta.insets = new Insets(0, 0, 5, 5);
		gbc_textKartalta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKartalta.gridx = 3;
		gbc_textKartalta.gridy = 2;
		contentPane.add(textKartalta, gbc_textKartalta);
		
		GridBagConstraints gbc_lblmm = new GridBagConstraints();
		gbc_lblmm.insets = new Insets(0, 0, 5, 0);
		gbc_lblmm.gridx = 4;
		gbc_lblmm.gridy = 2;
		contentPane.add(lblmm, gbc_lblmm);
		
		GridBagConstraints gbc_lblMatkaMaastossa = new GridBagConstraints();
		gbc_lblMatkaMaastossa.anchor = GridBagConstraints.EAST;
		gbc_lblMatkaMaastossa.insets = new Insets(0, 0, 0, 5);
		gbc_lblMatkaMaastossa.gridx = 1;
		gbc_lblMatkaMaastossa.gridy = 3;
		contentPane.add(lblMatkaMaastossa, gbc_lblMatkaMaastossa);
		
		GridBagConstraints gbc_textMaastossa = new GridBagConstraints();
		gbc_textMaastossa.insets = new Insets(0, 0, 0, 5);
		gbc_textMaastossa.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMaastossa.gridx = 3;
		gbc_textMaastossa.gridy = 3;
		contentPane.add(textMaastossa, gbc_textMaastossa);
		
		GridBagConstraints gbc_lblkm = new GridBagConstraints();
		gbc_lblkm.gridx = 4;
		gbc_lblkm.gridy = 3;
		contentPane.add(lblkm, gbc_lblkm);
	}
// ================================ omat aliohjelmat =============

	
	/** Oletusmittakaava */
	    public static final double MITTAKAAVA = 200000.0;

	    /**  Kuinka paljon millimetrit ovat kilometrein‰ */
	    public static final double MM_KM = 1000.0 * 1000.0;
	
	    /**
	     * Lasketaan kartalla mm mitattu matka luonnossa km
	     * @param matka_mm matka joka muutetaan
	     * @param mittakaava mik‰ on kartan mittakaava
	     * @return mm kilometrein‰ 1:200000 kartalla
	     */
	    public static double mittakaavamuunnos(int matka_mm, double mittakaava) {
	        return matka_mm * mittakaava / MM_KM;
	    }

	    /**
	     * Haetaan tekstikent‰ss‰ oleva kokonaisluku 
	     * @param text kentt‰ josta kokonaisluku haetaan
	     * @param oletus mik‰ on luvun arvo jos kent‰st‰ ei saada j‰rkev‰‰ lukua
	     * @return kent‰st‰ haettu kokonaisluku
	     */
	    public static int haeLuku(JTextField text, int oletus) {
	        int luku = Mjonot.erotaInt(text.getText(), oletus);
	        return luku;
	    }


	    /**
	     * Haetaan tekstikent‰ss‰ oleva kokonaisluku 
	     * @param text kentt‰ josta kokonaisluku haetaan
	     * @param oletus mik‰ on luvun arvo jos kent‰st‰ ei saada j‰rkev‰‰ lukua
	     * @return kent‰st‰ haettu kokonaisluku
	     */
	    public static double haeLuku(JTextField text, double oletus) {
	        double luku = Mjonot.erotaDouble(text.getText(), oletus);
	        return luku;
	    }
	    
	    
	    /**
	     * Laitetaan luku valittuun tekstikentt‰‰n
	     * @param text tekstikentt‰ johon tulos laitetaan
	     * @param luku tekstikent‰‰n laitettava luku
	     */
	    public static void laitaTulos(JTextField text, double luku) {
	        String tulos = String.format("%5.3f", luku);
	        tulos = tulos.replace(',', '.'); // jos halutaan desimaalipiste eik‰ pilkku
	        text.setText(tulos);
	    }
	    protected void vaihda(){
	    	
	        int matka_mm; // yksinkertaisen tarkkuuden kokonaisluku
	        matka_mm = haeLuku(textKartalta, 0);
	        double mittakaava = haeLuku(textMittakaava, MITTAKAAVA);

	        double matka_km = mittakaavamuunnos(matka_mm, mittakaava);
	        laitaTulos(textMaastossa, matka_km);
		

		
	}
	
}
