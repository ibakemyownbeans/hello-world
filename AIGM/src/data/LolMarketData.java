package data;

import java.io.Serializable;

public class LolMarketData implements Serializable {

	private static final long serialVersionUID = -1105380789952238797L;
	
	private int numbers[][];
	
	public LolMarketData() {
		numbers = new int[10][6];
	}
	
	public int[][] getNumbers() {
		return this.numbers;
	}
	
	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}

}
