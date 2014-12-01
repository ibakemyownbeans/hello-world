package data;

import java.io.Serializable;

public class Singleton implements Serializable {
	
	private static final long serialVersionUID = 7188529489305321872L;
	private static Singleton singleton = null;

	private LolMarketData lmd;
	
	protected Singleton() {
		lmd = new LolMarketData();
	}
	
	public static Singleton getInstance() {
		if(singleton == null) 
			singleton = new Singleton();
		
		return singleton;
	}
	
	public static void setInstance(Singleton single) {
		if(singleton == null)
			singleton = single;
	}
	
	public LolMarketData getMarketData() {
		return lmd;
	}
	
	public void setMarketData(LolMarketData lmd) {
		this.lmd = lmd;
	}

}
