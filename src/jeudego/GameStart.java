package jeudego;

import java.awt.Color;
import javax.swing.JFrame;


public class GameStart {
	public static void main(String arg[]){
		JFrame frame = new JFrame("Jeu de Go"); // initialiser
		JeuDeGo playgame = new JeuDeGo();
		playgame.setBackground(new Color(139,69,19)); // etablir le couleur
		frame.add(playgame);
		frame.setSize(800, 800); // etablir les tailles
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}