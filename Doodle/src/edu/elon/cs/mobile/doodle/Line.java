package edu.elon.cs.mobile.doodle;

import android.graphics.Paint;

public class Line {
	protected int startX;
	protected int startY;
	protected int endX;
	protected int endY;
	protected Paint paint;
	
	public Line(int startX, int startY, Paint p, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.paint = p;
	}

}
