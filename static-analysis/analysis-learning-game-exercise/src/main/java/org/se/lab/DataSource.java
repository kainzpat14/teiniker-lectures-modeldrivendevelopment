package org.se.lab;

public class DataSource {
	int A = 1;
	int B = 2;
	int C = 3;
	int D = 4;
	MultiDataCell srcData[][];
	MultiDataCell outData[][];
	Boolean swapRowCol = false;
	
	public DataSource(){
		srcData = new MultiDataCell[4][5];
		
		setData(A,1,new MultiDataCell("X"));
		setData(A,2,new MultiDataCell("X"));
		setData(A,3,new MultiDataCell("oberste Ebene","obere Ebene"));
		setData(A,4,new MultiDataCell("mittlere Ebene"));
		setData(A,5,new MultiDataCell("untere Ebene","unterste Ebene"));
		
		setData(B,1,new MultiDataCell("Gesetzgebung","Gesetzgeber"));
		setData(B,2,new MultiDataCell("Legislative"));
		setData(B,3,new MultiDataCell("Parlament"));
		setData(B,4,new MultiDataCell("Landtag"));
		setData(B,5,new MultiDataCell("Gemeinderat","Gemeinderäte"));
		
		setData(C,1,new MultiDataCell("ausführende Gewalt","Ausführer","Ausführung"));
		setData(C,2,new MultiDataCell("Exekutive"));
		setData(C,3,new MultiDataCell("Bundesregierung","Kanzler","Minister"));
		setData(C,4,new MultiDataCell("Landesregierung","Landesregierungen"));
		setData(C,5,new MultiDataCell("Gemeinderegierung","Gemeinderegierungen"));
		
		setData(D,1,new MultiDataCell("Kontrolle","richterliche Gewalt"));
		setData(D,2,new MultiDataCell("Judikative"));
		setData(D,3,new MultiDataCell("oberster Gerichtshof","oberste Gerichtshöfe"));
		setData(D,4,new MultiDataCell("Landesgericht","Landesgerichte"));
		setData(D,5,new MultiDataCell("Bezirksgericht","Bezirksgerichte"));
		
		if (false) {
			setData(A,1,new MultiDataCell("X"));
			setData(A,2,new MultiDataCell("X"));
			setData(A,3,new MultiDataCell("A3","A3X"));
			setData(A,4,new MultiDataCell("A4","A4X"));
			setData(A,5,new MultiDataCell("A5","A5X"));
			
			setData(B,1,new MultiDataCell("B1","B1X"));
			setData(B,2,new MultiDataCell("B2","B2X"));
			setData(B,3,new MultiDataCell("B3","B3X"));
			setData(B,4,new MultiDataCell("B4","B4X"));
			setData(B,5,new MultiDataCell("B5","B5X"));
			
			setData(C,1,new MultiDataCell("C1","C1X"));
			setData(C,2,new MultiDataCell("C2","C2X"));
			setData(C,3,new MultiDataCell("C3","C3X"));
			setData(C,4,new MultiDataCell("C4","C4X"));
			setData(C,5,new MultiDataCell("C5","C5X"));
			
			setData(D,1,new MultiDataCell("D1","D1X"));
			setData(D,2,new MultiDataCell("D2","D2X"));
			setData(D,3,new MultiDataCell("D3","D3X"));
			setData(D,4,new MultiDataCell("D4","D4X"));
			setData(D,5,new MultiDataCell("D5","D5X"));
		}
		
		getData(A,3).setHead(true);
		getData(A,4).setHead(true);
		getData(A,5).setHead(true);
		
		getData(B,1).setHead(true);
		getData(B,2).setHead(true);
		getData(C,1).setHead(true);
		getData(C,2).setHead(true);
		getData(D,1).setHead(true);
		getData(D,2).setHead(true);
	}
	
	private MultiDataCell getData(int x, int y){
		return srcData[x-1][y-1];
	}

	public MultiDataCell setData(int col, int row, MultiDataCell value){
		srcData[col-1][row-1] = value;
		return value;
	}
	
	public void randomize(){
		swapRowCol = MainWindow.getRandom().nextBoolean();
		
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 5 ; y++)
			{
				srcData[x][y].randomizeText();
				srcData[x][y].setUserText("");
				srcData[x][y].setDisplay(false);
			}
		}
		
		int swapMatrix_X[][] = {
			{0,1,2,3},
			{0,1,3,2},
			{0,2,1,3},
			{0,2,3,1},
			{0,3,1,2},
			{0,3,2,1},
		};
		int swapMatrix_Y[][] = {
				{0,1,2,3,4},
				{0,1,2,4,3},
				{0,1,3,2,4},
				{0,1,3,4,2},
				{0,1,4,2,3},
				{0,1,4,3,2},
			};
		
		int swaprule1 = MainWindow.getRandom().nextInt(6);
		int swaprule2 = MainWindow.getRandom().nextInt(6);

		
		MultiDataCell[][] swappedSrcData = new MultiDataCell[4][5];
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 5 ; y++)
				swappedSrcData[swapMatrix_X[swaprule1][x]]
				              [swapMatrix_Y[swaprule2][y]] = srcData[x][y];
		}
		
		for (int x = 0; x < 4; x++){
			int itemYtoDisplay;
			randomloop:
			while (true) {
			
				itemYtoDisplay = MainWindow.getRandom().nextInt(5);
				for (int x2 = 0; x2 < x ; x2++)
				{
					MultiDataCell item = swappedSrcData[x2][itemYtoDisplay];
					if (item.isDisplay()) 
						continue randomloop;

					
				}
				
				MultiDataCell item = swappedSrcData[x][itemYtoDisplay];
				if (!item.isUsed()) continue randomloop;
				item.setDisplay(true);
				break;
			}	
			
		}
		
		

		if (!swapRowCol) {
			outData = new MultiDataCell[4][5];
			for (int x = 0; x < 4; x++){
				for (int y = 0; y < 5 ; y++)
					outData[x][y] = swappedSrcData[x][y];
			}
		} else {
			outData = new MultiDataCell[5][4];
			for (int x = 0; x < 4; x++){
				for (int y = 0; y < 5 ; y++)
					outData[y][x] = swappedSrcData[x][y];
			}

		}
		
		
		
	}

	public int getRowCount() {
		if (swapRowCol)
			return 5;
		else
			return 4;
	}
	
	public int getColumnCount() {
		if (swapRowCol)
			return 4;
		else
			return 5;
	}

	public String getTextAt(int row, int col) {
		try {
			return outData[row][col].getDisplayedText();	
		} catch (ArrayIndexOutOfBoundsException exc) {
			return "ERROR " + Integer.toString(row) + "  ;  " + Integer.toString(col);
		}
	}

	public boolean isCellEditable(int row, int col) {
		MultiDataCell cell = outData[row][col];
		return !cell.isDisplay();
	}

	public Object getDataAt(int row, int col) {
		return outData[row][col];
	}

	public void setUserData(String value, int arg1, int arg2) {
		this.outData[arg1][arg2].setUserText(value);		
	}
}
