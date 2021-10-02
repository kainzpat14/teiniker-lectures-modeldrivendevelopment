package org.se.lab;

import java.awt.Color;

public class MultiDataCell {
	
	private String[] dataList;
	private String displayedText;
	private boolean used = true;
	private boolean display = true;
	private boolean head;
	private String userText;
	
	public MultiDataCell(String... dataList) {
		if (dataList.length == 1 && dataList[0] == "X"){
			this.dataList = new String[1];
			this.dataList[0] = "";
			this.setUsed(false);
		}
		
		this.dataList = dataList;
	}
	
	public void randomizeText(){
		if (this.dataList.length==0){
			this.displayedText = "ERROR";
			return;
		}
		int randomIndex = MainWindow.getRandom().nextInt(dataList.length);
		this.displayedText = dataList[randomIndex];
	}

	public String getDisplayedText() {
		if (isUsed())
			return displayedText;
		else
			return "";
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}
	
	@Override
	public String toString() {
		if (this.display)
			return this.getDisplayedText();
		else 
			return this.userText;
	}
	
	int getUserTextErrors(){
		int val = Integer.MAX_VALUE;
		for(String txt: this.dataList){
			val = Math.min(computeDiff(this.userText, txt),val);
		}
		return val;
	}
	

	public Color getBackgroundColor() {
		if (!this.used)
			return Color.GRAY;
		
		if (this.display)
			return Color.LIGHT_GRAY;
		
		
		
		if (this.userText.isEmpty()) {
			if (this.head) return Color.YELLOW;
			return Color.WHITE;
		}
			
		int diffs = this.getUserTextErrors();
		//System.out.println("diff " + diffs);
		
		if (diffs == 2)
			return Color.ORANGE;
		
		if (diffs == 1)
			return Color.ORANGE;
		
		if (diffs == 0)
			return Color.GREEN;
		
		
		return Color.RED;
		
	}
	
    /// <summary>
    /// Compute the distance between two strings.
    /// </summary>
    public static int computeDiff(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        int[][] d = new int[n + 1][ m + 1];

        // Step 1
        if (n == 0)
        {
            return m;
        }

        if (m == 0)
        {
            return n;
        }

        // Step 2
        for (int i = 0; i <= n; d[i][0] = i++)
        {
        	
        }

        for (int j = 0; j <= m; d[0][j] = j++)
        {
        	
        }

        // Step 3
        for (int i = 1; i <= n; i++)
        {
            //Step 4
            for (int j = 1; j <= m; j++)
            {
                // Step 5
                int cost = (t.charAt(j - 1) == s.charAt(i - 1) ? 0 : 1);

                // Step 6
                d[i][j] = Math.min(
                    Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1),
                    d[i - 1][j - 1] + cost);
            }
        }
        // Step 7
        return d[n][m];
    }

	public void setHead(boolean b) {
		this.head = true;		
	}

	public void setUserText(String text) {
		this.userText = text;		
	}
	
}
