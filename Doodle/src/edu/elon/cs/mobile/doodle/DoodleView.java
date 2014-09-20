package edu.elon.cs.mobile.doodle;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DoodleView extends View {
	
	protected int width = 25;
	protected int r = 0;
	protected int g = 0;
	protected int b = 0;
	protected int a = 255;
	private ArrayList<Dot> dots;
	protected ArrayList<Line> lines;
	int prevX;
	int prevY;

	public DoodleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		dots = new ArrayList<Dot>();
		lines = new ArrayList<Line>();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		int action = event.getActionMasked();
		Paint paint = new Paint();
		paint.setColor(new Color().argb(a, r, g, b));
		paint.setStrokeWidth(width);
		paint.setStrokeCap(Paint.Cap.ROUND);
		if (action == MotionEvent.ACTION_DOWN) {
			//Dot dot = new Dot((int) event.getX(), (int) event.getY(), width, paint);
			//dots.add(dot);
			//invalidate();
			System.out.println("FOUND A TOUCH!");
			prevX = (int)event.getX();
			prevY = (int)event.getY();
		}
		if (action == MotionEvent.ACTION_MOVE) {
			Line line = new Line(prevX, prevY, paint, (int) event.getX(), (int) event.getY());
			lines.add(line);
			invalidate();
			System.out.println("FOUND A TOUCH!");
			prevX = (int)event.getX();
			prevY = (int)event.getY();
		}
		
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (Dot dot : dots) {
			canvas.drawCircle(dot.x, dot.y, dot.r, dot.paint);
		}
		for(Line line : lines){
			canvas.drawLine(line.startX, line.startY, line.endX, line.endY, line.paint);
		}
	}

}



