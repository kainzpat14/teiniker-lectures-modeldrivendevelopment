package org.se.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("test3"));
		Scanner vhod=new Scanner(System.in);
		ArrayList <Matrika> seznamMatrik=new ArrayList<Matrika>();	//seznam v katerem so shranjene matrike
		ArrayList <String> izraz=new ArrayList<String>();	//za shranjevanje izraza
		int naslednji=0;	//za preverjanje dvojic pri izpisu
		int[] izpis=new int[2];	//shranjevanje dvojice v tabelo
		ArrayList <int[]> izpisS=new ArrayList<int[]>();	//shranjevanje dvojic v seznam

		while(vhod.hasNext()){
			String preveri=vhod.next();

			if(preveri.equals("izraz:")){	//ko se pojavi "izraz:"
				while(vhod.hasNext()){
					preveri=vhod.next();
					if(preveri.equals("izpis:")){	//ko se pojavi "izpis:"
						while(vhod.hasNext()){
							if(naslednji%2==0){	//prva "koordinata"
								izpis[0]=vhod.nextInt();
								naslednji++;
							}
							else{	//druga "koordinata"
								izpis[1]=vhod.nextInt();
								naslednji++;
								izpisS.add(izpis);
								izpis=new int[2];
							}
						}
					}
					else{	//doda posamezni del izraza v seznam
						if (preveri.substring(0, 1).equals("^")){
							izraz.add(preveri.substring(0, 1));
							izraz.add(preveri.substring(1, 2));
						}
						else{
							izraz.add(preveri);
						}
					}
				}
			}
			else{
				Matrika vnos=new Matrika();	//spremenljivka tipa Matrika
				vnos.ime=preveri;	//prebere ime matrike
				int x=vhod.nextInt();	//prebere dimenzijo matrike
				int y=vhod.nextInt();

				vnos.matrika=new int[x][y];	//prebere matriko in jo shrani v tabelo
				for(int i=0; i<x; i++){
					for(int j=0; j<y; j++){
						vnos.matrika[i][j]=vhod.nextInt();
					}
				}
				seznamMatrik.add(vnos);	//podatke o matriki shrani v seznam
			}
		}

		int st=izraz.size();	//dolzina izraza
		String znak;
		Stack<int[][]> izracun=new Stack<int[][]>();	//sklad ki shranjuje matrike
		for(int i=0; i<st; i++){
			int[][] A;
			int[][] B;
			int[][] A1;
			int[][] B1;
			int[] dimenzija=new int[2];
			znak=izraz.get(i);
			if(znak.equals("+")){
				B=izracun.pop();
				A=izracun.pop();
				izracun.push(sestevanje(A, B));
			}
			else if(znak.equals("-")){
				B=izracun.pop();
				A=izracun.pop();
				izracun.push(odstevanje(A, B));
			}
			else if(znak.equals("*")){
				B=izracun.pop();
				A=izracun.pop();
				dimenzija[0]=A.length;
				dimenzija[1]=B[0].length;
				A1=razsiri(A);
				B1=razsiri(B);
				izracun.push(skrci(strassen(A1, B1, A1.length), dimenzija));
			}
			else if(znak.equals("T")){
				A=izracun.pop();
				izracun.push(transponiranje(A));
			}
			else if(znak.equals("^")){
				A=izracun.pop();
				i++;
				A1=razsiri(A);
				dimenzija[0]=A.length;
				dimenzija[1]=A[0].length;
				znak=izraz.get(i);
				izracun.push(skrci(potenciranje(A1, Integer.parseInt(znak)), dimenzija));
			}
			else{	//ce se pojavi v izrazu matrika
				int index=0;
				String ime;
				for(int j=0; j<seznamMatrik.size(); j++){
					ime=seznamMatrik.get(j).ime;
					if(znak.equals(ime)){
						index=j;
						break;
					}
				}
				izracun.push(seznamMatrik.get(index).matrika);
			}
		}
		int[][] zadnji=izracun.pop();
		int[] izhod;
		for(int i=0; i<izpisS.size(); i++){
			izhod=izpisS.get(i);
			System.out.print(zadnji[izhod[0]-1][izhod[1]-1]);
			System.out.println();
		}
	}

	public static int[][] sestevanje(int[][] A, int[][] B){
		int[][] C=new int[A.length][A[0].length];
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[i].length; j++){
				C[i][j]=A[i][j]+B[i][j];
			}
		}
		return C;
	}

	public static int[][] odstevanje(int[][] A, int[][] B){
		int[][] C=new int[A.length][A[0].length];
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[i].length; j++){
				C[i][j]=A[i][j]-B[i][j];
			}
		}
		return C;
	}

	public static int[][] transponiranje(int[][] A){
		int[][] C=new int[A[0].length][A.length];
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[i].length; j++){
				C[j][i]=A[i][j];
			}
		}
		return C;
	}

	public static int[][] mnozenje(int[][] A, int[][] B){
		int[][] C=new int[A.length][B[0].length];
		for(int i=0; i<A.length; i++){
			for(int j=0; j<B[i].length; j++){
				for(int k=0; k<A[i].length; k++){
					C[i][j]=C[i][j]+A[i][k]*B[k][j];
				}
			}
		}
		return C;
	}

	public static int[][] strassen(int[][] A, int[][] B, int n){
		int[][] C=new int[n][n];	//ustrezne priprave podmatrik
		int[][] A1=new int[n/2][n/2];
		int[][] A2=new int[n/2][n/2];
		int[][] A3=new int[n/2][n/2];
		int[][] A4=new int[n/2][n/2];
		int[][] B1=new int[n/2][n/2];
		int[][] B2=new int[n/2][n/2];
		int[][] B3=new int[n/2][n/2];
		int[][] B4=new int[n/2][n/2];
		int vr=0;
		int st=0;
		int[][] M1=new int[n/2][n/2];
		int[][] M2=new int[n/2][n/2];
		int[][] M3=new int[n/2][n/2];
		int[][] M4=new int[n/2][n/2];
		int[][] M5=new int[n/2][n/2];
		int[][] M6=new int[n/2][n/2];
		int[][] M7=new int[n/2][n/2];
		int[][] C1=new int[n/2][n/2];
		int[][] C2=new int[n/2][n/2];
		int[][] C3=new int[n/2][n/2];
		int[][] C4=new int[n/2][n/2];

		if(n<100){
			C=mnozenje(A, B);
		}
		else{
			for(int i=0; i<n/2; i++){	// razdeli na manjse bloke
				for(int j=0; j<n/2; j++){
					A1[vr][st]=A[i][j];
					B1[vr][st]=B[i][j];
					A2[vr][st]=A[i][j+n/2];
					B2[vr][st]=B[i][j+n/2];
					A3[vr][st]=A[i+n/2][j];
					B3[vr][st]=B[i+n/2][j];
					A4[vr][st]=A[i+n/2][j+n/2];
					B4[vr][st]=B[i+n/2][j+n/2];
					st++;
				}
				st=0;
				vr++;
			}
			M1=strassen(sestevanje(A1, A4), sestevanje(B1, B4), n/2);
			M2=strassen(sestevanje(A3, A4), B1, n/2);
			M3=strassen(A1, odstevanje(B2, B4), n/2);
			M4=strassen(A4, odstevanje(B3, B1), n/2);
			M5=strassen(sestevanje(A1, A2), B4, n/2);
			M6=strassen(odstevanje(A3, A1), sestevanje(B1, B2), n/2);
			M7=strassen(odstevanje(A2, A4), sestevanje(B3, B4), n/2);

			C1=sestevanje(sestevanje(M1, M4), odstevanje(M7, M5));
			C2=sestevanje(M3, M5);
			C3=sestevanje(M2, M4);
			C4=sestevanje(odstevanje(M1, M2), sestevanje(M3, M6));

			st=0;
			vr=0;
			for(int i=0; i<n/2; i++){	//manjse C# zdruzi v C
				for(int j=0; j<n/2; j++){
					C[i][j]=C1[vr][st];
					C[i][j+n/2]=C2[vr][st];
					C[i+n/2][j]=C3[vr][st];
					C[i+n/2][j+n/2]=C4[vr][st];
					st++;
				}
				st=0;
				vr++;
			}
		}
		return C;
	}

	public static int[][] razsiri(int[][] A){	//razsiri matriko na matriko stopnje 2^n*2^n
		int potenca=0;
		int n=1;
		int vr=A.length;
		int st=A[0].length;
		int[][] C;

		while(potenca<A.length | potenca<A[0].length){	//dokler vrstice in stolpci vecje od neke 2^n
			potenca=(int)Math.pow(2, n);
			vr=potenca;
			st=potenca;
			n++;
		}
		if(vr==A.length & st==A[0].length){
			return A;
		}
		else{
			C=new int[vr][st];
			for(int i=0; i<A.length; i++){
				for(int j=0; j<A[0].length; j++){
					C[i][j]=A[i][j];
				}
			}
			return C;
		}
	}

	public static int[][] skrci(int[][] A, int[] dimenzija){	//skrci razsirjeno matriko na prvotno obliko
		int[][] D=new int[dimenzija[0]][dimenzija[1]];
		for(int i=0; i<dimenzija[0]; i++){
			for(int j=0; j<dimenzija[1]; j++){
				D[i][j]=A[i][j];
			}
		}
		return D;
	}

	public static int[][] potenciranje(int[][] A, int n){
		int[][] B=new int[A.length][A[0].length];

		for(int i=0; i<A.length; i++){
			B[i][i]=1;
		}
		for(int i=0; i<n; i++){
			B=strassen(B, A, B.length);
		}
		return B;
	}
}
