/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JeuDeGo extends JPanel{
	//建立存储棋子的二维数组
	private Pierre AllChess[][] = new Pierre[JeuConfig.NombreDeColone+2][JeuConfig.NombreDeLigne+2];
       	//黑白棋判断变量
	public static boolean BlackWhite = true;
        //
        public static boolean changeTurn = false;
        //count of pierre noir
        private int countPN;
        //count of pierre blanc
        private int countPW;
        //
        private int flag;

        //游戏内容
	public JeuDeGo(){
        countPN = 0;
        countPW = 0;
	//AllChess数组初始化
        for(int j=0;j<JeuConfig.NombreDeColone+2;j++){
            for(int i=0;i<JeuConfig.NombreDeLigne+2;i++){
                if(i == 0 || j == 0 || i == JeuConfig.NombreDeColone + 1 || j == JeuConfig.NombreDeLigne + 1){
                    AllChess[i][j] = new Pierre(i, j, Color.gray);
                }else{
                    AllChess[i][j] = new Pierre(i, j, Color.yellow);
                }
            }
        }
	addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e) {
                int x = CorrectXY(e.getX());
                int y = CorrectXY(e.getY());
                //boolean turn;
                if(BlackWhite){
                    if(AllChess[x][y].isSameColor(Color.yellow)){
                        AllChess[x][y].setColor(Color.black);
                        Judge(x, y, Color.white);
                        if(AllChess[x][y].isSameColor(Color.black)){
                            BlackWhite = false;
                            changeTurn = true;
                        }else{
                            changeTurn = false;
                        }           
                    }
                }
                else {
                    if(AllChess[x][y].isSameColor(Color.yellow)){
                        AllChess[x][y].setColor(Color.white);
                        Judge(x, y, Color.black);
                        if(AllChess[x][y].isSameColor(Color.white)){
                            BlackWhite = true;  
                            changeTurn = true;
                        }else{
                            changeTurn = false;
                        }                 
                    }
                }
                repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub	
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub	
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub	
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub	
            }
        });
        }
		
	//判断是否胜利
        public void Judge(int x, int y, Color c){
            //Groupe
            Groupe p1 = new Groupe();
            ArrayList<Groupe> p2 = new ArrayList<>();
            Groupe pcheck;
            
            countDownKo(changeTurn);
            p1.initialPierre(AllChess[x][y]);
            searchGroupe1(p1, 0);
            //p1.affichageGroupe();
            for(int j=1;j<JeuConfig.NombreDeColone+1;j++){
                for(int i=1;i<JeuConfig.NombreDeLigne+1;i++){
                    if(AllChess[i][j].isSameColor(c) && ((i-x)*(i-x) + (j-y)*(j-y) <=2) && !AllChess[i][j].isMembre()){
                        Groupe g = new Groupe();
                        g.initialPierre(AllChess[i][j]);
                        searchGroupe2(g, 0);
                        //g.affichageGroupe();
                        p2.add(g);
                    }
                }
            }
            if(noLiberte(p1)){
                if(!judgeGroupe(p2)){
                    AllChess[x][y].setColor(Color.yellow);
                }
                else{
                    removeListGroupe(p2);
                }
            }else{
                if(p1.getGroupe().get(0).getKo() != 0){
                    AllChess[x][y].setColor(Color.yellow);
                }else{
                    for(Groupe pi : p2){
                        if(noLiberte(pi)){
                            removeGroupe(pi);
                        }
                    }
                }
            }
            p1.resetGroupe();
            for(Groupe pi : p2){
                pi.resetGroupe();
            }
	}
	//游戏结束
	public void GameOver(String str){
    	Calendar cal = new GregorianCalendar();
    	str = str + "\n 点击确定结束游戏" + "\n 当前时间" + cal.getTime().toString();
        JOptionPane.showMessageDialog(null, str, "游戏结束————by David Chang", 1);
    	System.exit(0);
        }
	//校对坐标
	public int CorrectXY(int x){
		int a;
		a = x % JeuConfig.DamierSize;
		if(a < (JeuConfig.DamierSize / 2)) x = x / JeuConfig.DamierSize;
		else if(a >= (JeuConfig.DamierSize / 2)) x = x / JeuConfig.DamierSize + 1;
		return x ;
	}
        //liberte
        public boolean noLiberte(Groupe g){
            for(int j=0;j<JeuConfig.NombreDeColone+2;j++){
               for(int i=0;i<JeuConfig.NombreDeLigne+2;i++){
                   for(Pierre p : g.getGroupe()){
                       if((i-p.getX())*(i-p.getX())+(j-p.getY())*(j-p.getY()) < 2 && (i-p.getX())*(i-p.getX())+(j-p.getY())*(j-p.getY()) != 0 && p.isBorder()){
                           if(AllChess[i][j].isSameColor(Color.yellow) || AllChess[i][j].isSameColor(Color.red)) return false;
                       }
                   }
               }
            }
            return true;
        }
        public boolean noLiberte(Pierre p){
            if(p.isBorder()){
                for(int j=0;j<JeuConfig.NombreDeColone+2;j++){
                    for(int i=0;i<JeuConfig.NombreDeLigne+2;i++){
                        if((i-p.getX())*(i-p.getX())+(j-p.getY())*(j-p.getY()) < 2 && (i-p.getX())*(i-p.getX())+(j-p.getY())*(j-p.getY()) != 0){
                            if(AllChess[i][j].isSameColor(Color.yellow) || AllChess[i][j].isSameColor(Color.red)) return false;
                        }
                    }
                }
            }
            return true;
        }
        public void removeListGroupe(ArrayList<Groupe> listgroupe){
            for(Groupe g : listgroupe){
                removeGroupe(g);
            }
        }        
        //remove Groupe
        public void removeGroupe(Groupe g){
            if(g.getGroupe().size()> 1){
                for(Pierre p : g.getGroupe()){
                if(p.isSameColor(Color.white)) countPW++;
                else if(p.isSameColor(Color.black)) countPN++;
                p.setColor(Color.red);
                }
            }else if(g.getGroupe().size() == 1){
                Pierre p = g.getGroupe().get(0);
                if(p.isSameColor(Color.white)) countPW++;
                else if(p.isSameColor(Color.black)) countPN++;
                p.setColor(Color.yellow);
                p.setKo(2);
            }           
        }       
        //search group
        public void searchGroupe1(Groupe g, int index){
            Pierre pi = g.getGroupe().get(index);
            int x =pi.getX();
            int y = pi.getY();
            Color c = pi.getColor();
            
            for(int j=1;j<JeuConfig.NombreDeColone+1;j++){
                for(int i=1;i<JeuConfig.NombreDeLigne+1;i++){
                    if(((i-x)*(i-x) + (j-y)*(j-y) <=2) && AllChess[i][j].isSameColor(c) && !AllChess[i][j].isMembre()){
                       g.ajouterPierre(AllChess[i][j]);               
                    }
                }
            }
            if(index < g.getGroupe().size() - 1){
                searchGroupe1(g, index + 1);       
            }else if(index == g.getGroupe().size() - 1){
                for(Pierre p : g.getGroupe()){
                g.updateGroupe(p);
                }
            }    
        }
        
        public void searchGroupe2(Groupe g, int index){
            Pierre pi = g.getGroupe().get(index);
            int x =pi.getX();
            int y = pi.getY();
            Color c = pi.getColor();
            
            for(int j=1;j<JeuConfig.NombreDeColone+1;j++){
                for(int i=1;i<JeuConfig.NombreDeLigne+1;i++){
                    if(((i-x)*(i-x) + (j-y)*(j-y) <2) && AllChess[i][j].isSameColor(c) && !AllChess[i][j].isMembre()){
                       g.ajouterPierre(AllChess[i][j]);               
                    }
                }
            }
            if(index < g.getGroupe().size() - 1){
                searchGroupe2(g, index + 1);       
            }else if(index == g.getGroupe().size() - 1){
                for(Pierre p : g.getGroupe()){
                g.updateGroupe(p);
                }
            }    
        }
        
        public boolean judgeGroupe(ArrayList<Groupe> groupe){
            for(Groupe g : groupe){
                if(!noLiberte(g)){
                    return false;
                }
            }        
            return true;
        }
        public void countDownKo(boolean flag){
              
            for(int j=1;j<JeuConfig.NombreDeColone+1;j++){
                for(int i=1;i<JeuConfig.NombreDeLigne+1;i++){
                    AllChess[i][j].countKo(flag);
                }
            }
        }
        
	//paint
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            //draw chesspad
            for(int i=1;i<JeuConfig.NombreDeColone+1;i++){
                g.setColor(Color.black);
                g.drawLine(i*JeuConfig.DamierSize, JeuConfig.DamierSize, i*JeuConfig.DamierSize,JeuConfig.NombreDeLigne*JeuConfig.DamierSize);
            }
            for(int i=1;i<JeuConfig.NombreDeLigne+1;i++){
                g.setColor(Color.black);
                g.drawLine(JeuConfig.DamierSize, i*JeuConfig.DamierSize, JeuConfig.NombreDeColone*JeuConfig.DamierSize, i*JeuConfig.DamierSize);
            }
            //draw pierre
            for(int j=0;j<JeuConfig.NombreDeLigne+2;j++){
                for(int i=0;i<JeuConfig.NombreDeColone+2;i++){
                    if((AllChess[i][j].isSameColor(Color.black)) || (AllChess[i][j].isSameColor(Color.white))){
                        g.setColor(AllChess[i][j].getColor());
                        g.fillOval(AllChess[i][j].getX() * JeuConfig.DamierSize - JeuConfig.DamierSize / 2, 
                                   AllChess[i][j].getY() * JeuConfig.DamierSize - JeuConfig.DamierSize / 2, 
                                   JeuConfig.ChessSize, JeuConfig.ChessSize);
                    }
                }
            }
        }
}
