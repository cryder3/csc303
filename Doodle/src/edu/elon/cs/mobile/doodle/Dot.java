package edu.elon.cs.mobile.doodle;

import android.graphics.Paint;

public class Dot {

	protected int x;
	protected int y;
	protected int r;
	protected Paint paint;
	
	public Dot(int x, int y, int r, Paint p) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.paint = p;
		
	}
}
