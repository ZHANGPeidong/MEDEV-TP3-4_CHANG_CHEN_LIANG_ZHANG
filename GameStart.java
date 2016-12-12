package jeudego;

import java.awt.Color;
import javax.swing.JFrame;


public class GameStart {
	public static void main(String arg[]){
		JFrame frame = new JFrame("Jeu de Go————by David Chang");
		JeuDeGo playgame = new JeuDeGo();
		playgame.setBackground(new Color(139,69,19));
		frame.add(playgame);
		frame.setSize(640, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		}
}