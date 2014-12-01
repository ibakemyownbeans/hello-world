/**
 * @file: LOLMarket.java
 * @author: Brandon, 22 Sep 2014, QASMT
 * Lenovo Thinkpad, Eclipse
 */

package com.manager;

/**
 * @author Brandon
 *
 */
public class LOLMarket {

	private int[] curBuy, curSell, maxBuy, maxSell, minBuy, minSell, curOwned;

	public LOLMarket(int[] curBuy, int[] curSell, int[] maxBuy, int[] maxSell, int[] minBuy, int[] minSell,
			int[] curOwned) {
		this.curBuy = curBuy;
		this.curSell = curSell;
		this.maxBuy = maxBuy;
		this.maxSell = maxSell;
		this.minBuy = minBuy;
		this.minSell = minSell;
		this.curOwned = curOwned;
	}
	
	public void suggest() {
		for(int x = 0; x < curOwned.length; x++) {
			
		}
	}

}
