import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hearthstone extends JFrame {

	private JPanel contentPane;
	
	private static Minion boulderfistOgre = new Minion("Boulderfist Ogre", 6, 6, 7);
	private static Minion pitFighter = new Minion("Pit Fighter", 5, 5, 6);
	private static Minion magmaRager = new Minion("Magma Rager", 3, 5, 1);
	private static Minion riverCrocolisk = new Minion("River Crocolisk", 2, 2, 3);
	private static Minion ultrasaur = new Minion("Ultrasaur", 10, 7, 14);
	private static Minion murlocRaider = new Minion("Murloc Raider", 1, 2, 1);
	private static Minion chillwindYeti = new Minion("Chillwind Yeti", 4, 4, 5);
	private static Minion bloodfenRaptor = new Minion("Bloodfen Raptor", 2, 3, 2);
	private static Minion spiderTank = new Minion("Spider Tank", 3, 3, 4);
	private static Minion wisp = new Minion("Wisp", 0, 1, 1);
	
	private JTextField txtYourCardName;
	private JTextField txtTargetCardName;
	
	private Card selectedCard;
	private Card targetCard;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		LinkedList<Card> deck = new LinkedList<Card>();

		deck.add(boulderfistOgre);
		deck.add(pitFighter);
		deck.add(magmaRager);
		deck.add(riverCrocolisk);
		deck.add(ultrasaur);
		deck.add(murlocRaider);
		deck.add(chillwindYeti);
		deck.add(bloodfenRaptor);
		deck.add(spiderTank);
		deck.add(wisp);
		deck.add(boulderfistOgre);
		deck.add(pitFighter);
		deck.add(magmaRager);
		deck.add(riverCrocolisk);
		deck.add(ultrasaur);
		deck.add(murlocRaider);
		deck.add(chillwindYeti);
		deck.add(bloodfenRaptor);
		deck.add(spiderTank);
		deck.add(wisp);
		
		Hero hero = new Hero(deck);
		Hero enemy = new Hero(deck);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hearthstone frame = new Hearthstone(hero, enemy);
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
	public Hearthstone(Hero hero, Hero enemy) {
		setTitle("Hearthstone");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1215, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		contentPane.add(panel);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setBounds(10, 331, 89, 23);
		contentPane.add(btnDraw);
		
		JLabel lblAction = new JLabel("Action");
		lblAction.setBounds(10, 11, 46, 14);
		contentPane.add(lblAction);
		
		JLabel lblYourCard = new JLabel("Your Card:");
		lblYourCard.setBounds(10, 36, 59, 14);
		contentPane.add(lblYourCard);
		
		txtYourCardName = new JTextField();
		txtYourCardName.setEditable(false);
		txtYourCardName.setBounds(10, 53, 86, 20);
		contentPane.add(txtYourCardName);
		txtYourCardName.setColumns(10);
		
		JLabel lblTarget = new JLabel("Target:");
		lblTarget.setEnabled(false);
		lblTarget.setBounds(10, 100, 46, 14);
		contentPane.add(lblTarget);
		
		txtTargetCardName = new JTextField();
		txtTargetCardName.setEnabled(false);
		txtTargetCardName.setEditable(false);
		txtTargetCardName.setBounds(10, 118, 86, 20);
		contentPane.add(txtTargetCardName);
		txtTargetCardName.setColumns(10);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setEnabled(false);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPlay.setBounds(10, 149, 89, 23);
		contentPane.add(btnPlay);
		
		JButton btnPlayEnemy = new JButton("Play Enemy");
		btnPlayEnemy.setBounds(10, 365, 89, 23);
		contentPane.add(btnPlayEnemy);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setEnabled(false);
		btnAttack.setBounds(10, 183, 89, 23);
		contentPane.add(btnAttack);
		
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				hero.drawCard();
				Card newCard = hero.lastDrawn();
				
				contentPane.add(newCard);
				newCard.setLocation(166 + (99 * (hero.getHand().size() - 1)), 294);
				
				newCard.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

						txtYourCardName.setText(newCard.toString());
						selectedCard = newCard;
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						
						newCard.setBorderColour(Color.GREEN);
						newCard.update();
					}

					@Override
					public void mouseExited(MouseEvent e) {
						
						newCard.setBorderColour(Color.BLACK);
						newCard.update();
					}

					@Override
					public void mousePressed(MouseEvent e) {

						
					}

					@Override
					public void mouseReleased(MouseEvent e) {

						
					}
					
					
				});
				
			}
		});
		
		btnPlayEnemy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				enemy.drawCard();
				Card newCard = enemy.lastDrawn();
				
				contentPane.add(newCard);
				newCard.setLocation(166 + (99 * (enemy.getHand().size() - 1)), 94);
				
				newCard.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(newCard.isSelected())
						{
							txtTargetCardName.setText("");
							txtTargetCardName.setEnabled(false);
							lblTarget.setEnabled(false);
							targetCard = null;
							
							btnAttack.setEnabled(true);
						}
						else
						{
							newCard.setBorderColour(Color.RED);
							newCard.update();
							
							txtTargetCardName.setText(newCard.toString());
							txtTargetCardName.setEnabled(true);
							lblTarget.setEnabled(true);
							targetCard = newCard;
							
							btnAttack.setEnabled(true);
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						
						if(!newCard.isSelected())
						{
							newCard.setBorderColour(Color.RED);
							newCard.update();
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						
						if(!newCard.isSelected())
						{
							newCard.setBorderColour(Color.BLACK);
							newCard.update();
						}
					}

					@Override
					public void mousePressed(MouseEvent e) {

						
					}

					@Override
					public void mouseReleased(MouseEvent e) {

						
					}
					
					
				});
			}
		});
		
		btnAttack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				((Minion) selectedCard).fight((Minion) targetCard);
				
			}
			
		});
	}
}
