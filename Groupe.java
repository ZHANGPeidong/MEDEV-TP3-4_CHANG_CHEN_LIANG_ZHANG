/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Groupe { // classe Groupe pour stocker les pieces dans la meme groupe
    private ArrayList<Pierre> groupe;

    public Groupe() {
        this.groupe = new ArrayList<>();
    }

    public ArrayList<Pierre> getGroupe() {
        return groupe;
    }
       
    public void ajouterPierre(Pierre p){
        int i = 0;
        for(Pierre pi : groupe){
            if(p.isSamePierre(pi)){
                i++;
                break;
            }
        }
        if(i == 0){
            groupe.add(p);
            p.setMembre(true);
        }
    }
    public void initialPierre(Pierre p){
        groupe.add(p);
        p.setMembre(true);
    }
    public void updateGroupe(Pierre pi){
        int i = 0;
        int x = pi.getX();
        int y = pi.getY();
        
        for(Pierre p : groupe){
            if(p.getX() == x + 1 && p.getY() == y) i++;
            else if(p.getX() == x - 1 && p.getY() == y) i++;
            else if(p.getX() == x && p.getY() == y + 1) i++;
            else if(p.getX() == x && p.getY() == y + 1) i++;
        }
        if(i == 4){
            pi.setBorder(false);
            System.out.println(pi.isBorder());
        }
    }
    public void resetGroupe(){
        for(Pierre p : groupe){
            p.setMembre(false);
        }
    }
    public void affichageGroupe(){
        System.out.println("Affichage groupe");
        for(Pierre p : groupe){
            System.out.println(p.getX() + ", " + p.getY() + ", " + p.getColor() + ", " + p.isMembre());
        }
    }
}
