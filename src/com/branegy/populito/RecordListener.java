package com.branegy.populito;

public class RecordListener {
	
	protected Populito parent;
	protected Populito child;

	public RecordListener(Populito parent, Populito child)  {
		this.parent = parent;
		this.child  = child;
	}

	public void addRow() throws Exception {
		
	}

	public void commit() {
		child.commit();		
	}

	public void close() {
		child.close();
	}

}
