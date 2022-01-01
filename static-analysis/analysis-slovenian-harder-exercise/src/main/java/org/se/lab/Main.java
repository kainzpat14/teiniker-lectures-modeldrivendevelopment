package org.se.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static int[][] cilj={{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,0}};
	
	public static void main(String[] args) throws FileNotFoundException {
		int[][] tabela=new int[4][4];
		Scanner vhod=new Scanner(System.in);
		int vr=0;
		int st=0;
		
		StringTokenizer token = new StringTokenizer(vhod.nextLine(), ",");
		while (token.hasMoreTokens()) {
	         tabela[vr][st]=Integer.parseInt(token.nextToken(","));
	         st++;
	         if(st==4){
	        	 st=0;
	        	 vr++;
	         }
	     }
		Dvojica izhod=new Dvojica();
		izhod=IDA(tabela);
		System.out.println(izhod.resitev);
	}
	
	public static Dvojica IDA(int[][] tabela){
		Dvojica vhod=new Dvojica();
		vhod.cena=hevristika(tabela);
		vhod.resitev="";
		Dvojica izhod=new Dvojica();
		
		while(true){
			izhod=DFS(0, tabela, vhod.cena, vhod.resitev);
			vhod.cena=izhod.cena;
			if(!izhod.resitev.equals("")){
				return izhod;
			}
		}
	}
	
	public static Dvojica DFS(double zacC, int[][] tabela, double limit, String pot){
		
		double hev=hevristika(tabela);
		double minC=zacC+hev;
		Dvojica izpis=new Dvojica();
		if(minC>limit){
			izpis.resitev="";
			izpis.cena=minC;
			return izpis;
		}
		if(hev==0){
			izpis.resitev=pot;
			izpis.cena=limit;
			return izpis;
		}
		
		double naslednjaC=Double.POSITIVE_INFINITY;
		ArrayList<Naslednja> poteze=new ArrayList<Naslednja>();
		Dvojica izpis1=new Dvojica();
		poteze=naslednjePoteze(tabela);
		for(int i=0; i<poteze.size(); i++){
			double novaZacC=zacC+1;
			String zadnji="";
			if(pot.length()!=0)
				zadnji=pot.substring(pot.length()-1);
			if(!(zadnji.equals("U") & poteze.get(i).poteza.equals("D")) & !(zadnji.equals("D") & poteze.get(i).poteza.equals("U"))& !(zadnji.equals("R") & poteze.get(i).poteza.equals("L")) & !(zadnji.equals("L") & poteze.get(i).poteza.equals("R"))){
				izpis1=DFS(novaZacC, poteze.get(i).tabela, limit, pot+poteze.get(i).poteza);
				if(!izpis1.resitev.equals("")){
					return izpis1;
				}
				naslednjaC=Math.min(naslednjaC, izpis1.cena);
			}
			
		}
		izpis.resitev="";
		izpis.cena=naslednjaC;
		return izpis;
	}
	
	public static ArrayList<Naslednja> naslednjePoteze(int[][] tabela){
		int x=0;
		int y=0;
		ArrayList<Naslednja> poteze=new ArrayList<Naslednja>();
		Naslednja premik=new Naslednja();
		int[][] kopija;
		int stevilo;
		
		for(int i=0; i<tabela.length; i++){
			for(int j=0; j<tabela[i].length; j++){
				if(tabela[i][j]==0){
					x=i;
					y=j;
				}
			}
		}
		kopija=kopiraj(tabela);
		if(y!=3){
			stevilo=kopija[x][y+1];
			kopija[x][y]=stevilo;
			kopija[x][y+1]=0;
			premik.tabela=kopija;
			premik.poteza="L";
			poteze.add(premik);
			premik=new Naslednja();
			kopija=new int[4][4];
			kopija=kopiraj(tabela);
		}
		if(y!=0){
			stevilo=kopija[x][y-1];
			kopija[x][y]=stevilo;
			kopija[x][y-1]=0;
			premik.tabela=kopija;
			premik.poteza="R";
			poteze.add(premik);
			premik=new Naslednja();
			kopija=new int[4][4];
			kopija=kopiraj(tabela);
		}
		if(x!=3){
			stevilo=kopija[x+1][y];
			kopija[x][y]=stevilo;
			kopija[x+1][y]=0;
			premik.tabela=kopija;
			premik.poteza="U";
			poteze.add(premik);
			premik=new Naslednja();
			kopija=new int[4][4];
			kopija=kopiraj(tabela);
		}
		if(x!=0){
			stevilo=kopija[x-1][y];
			kopija[x][y]=stevilo;
			kopija[x-1][y]=0;
			premik.tabela=kopija;
			premik.poteza="D";
			poteze.add(premik);
			premik=new Naslednja();
			kopija=new int[4][4];
			kopija=kopiraj(tabela);
		}
		return poteze;
	}
	
	public static double hevristika(int[][] tabela){
		int cena=0;
		int napacni=0;
		for(int i=0; i<tabela.length; i++){
			for(int j=0; j<tabela[i].length; j++){
				for(int k=0; k<cilj.length; k++){
					int prekini=0;
					for(int l=0; l<cilj[k].length; l++){
						if(tabela[i][j]==cilj[k][l]){
							cena=cena+Math.abs(i-k)+Math.abs(j-l);
							if(Math.abs(i-k)+Math.abs(j-l)!=0)
									napacni++;
							prekini=1;
							break;
						}
					}
					if(prekini!=0)
						break;
				}
			}
		}
		return cena+napacni;
	}

	public static int[][] kopiraj(int[][] tabela){
		int[][] kopija=new int[4][4];
		for(int i=0; i<tabela.length; i++){
			for(int j=0; j<tabela[i].length; j++){
				kopija[i][j]=tabela[i][j];
			}
		}
		return kopija;
	}
}

class Dvojica{
	String resitev;
	double cena;
}

class Naslednja{
	int[][] tabela;
	String poteza;
}