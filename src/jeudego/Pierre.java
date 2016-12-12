/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.awt.Color;

/**
 *
 * @author Administrator
 */
public class Pierre {
    //attributs
    private int X;
    private int Y;
    private Color color;
    private boolean membre;
    private boolean border;
    private int ko;

    //getters and setters
    public int getX(){
	return this.X;
    }
    public void setX(int x){
	this.X = x;
    }
    public int getY(){
	return this.Y;
    }
    public void setY(int y){
	this.Y = y;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
	this.color = color;
    }

    public boolean isMembre() {
        return membre;
    }

    public void setMembre(boolean membre) {
        this.membre = membre;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public int getKo() {
        return ko;
    }

    public void setKo(int ko) {
        this.ko = ko;
    }
    
    //constructeurs
    Pierre(int x, int y, Color color){
	this.X = x;
        this.Y = y;
	this.color = color;
        this.membre = false;
        this.border = true;
        this.ko = 0;
    }
    Pierre(Pierre pierre){
        this.X = pierre.getX();
	this.Y = pierre.getY();
	this.color = pierre.getColor();
        this.membre = pierre.isMembre();
        this.ko = pierre.getKo();
    }
    public boolean isSameColor(Color c){
	return this.color.equals(c);
    }
    public boolean isSamePierre(Pierre p){
        if(this.X == p.getX() && this.Y == p.getY() && this.color == p.getColor()){
            return true;
        }
        return false;
    }
    public void countKo(boolean flag){
            if(flag && this.ko > 0) this.ko--;
    }
}

