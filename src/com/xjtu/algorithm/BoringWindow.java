package com.xjtu.algorithm;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoringWindow extends JFrame{
	
	public static void main(String []args){
		JFrame f=new BoringWindow();
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setSize(300, 200);
		f.setVisible(true);
	}

}

class Frame613 extends JFrame{
	public Frame613(){
		setTitle("613 rock");
		setSize(300, 200);
		setLocation(100, 200);
		
		Panel613 panel=new Panel613();
		Container cp=getContentPane();
		cp.add(panel);
	}
}

class Panel613 extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Hi", 75, 100);
	}
}
