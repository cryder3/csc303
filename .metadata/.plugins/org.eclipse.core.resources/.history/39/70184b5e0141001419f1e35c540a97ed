package edu.elon.cs.mobile.doodle;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends Activity {
	
	private Dialog currentDialog;
	private DoodleView doodleView;
	private Button clearButton;
	protected int r = 0;
	protected int g = 0;
	protected int b = 0;
	protected int a = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        doodleView = (DoodleView) findViewById(R.id.doodleview);
        clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				doodleView.lines = new ArrayList<Line>();
				doodleView.invalidate();			
			}
        });
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    		getMenuInflater().inflate(R.menu.main, menu);
    		return true;
    }
    
    public boolean showWidthDialog(MenuItem menuItem) {
    	
    		currentDialog = new Dialog(this);
    		currentDialog.setContentView(R.layout.width_dialog);
    		currentDialog.setTitle(R.string.choose_width);
    		
    		SeekBar widthSeekBar = (SeekBar) currentDialog.findViewById(R.id.seekbarwidth);
    		widthSeekBar.setOnSeekBarChangeListener(widthSeekBarListener);
    		widthSeekBar.setProgress(25);
    		
    		Button widthButton = (Button) currentDialog.findViewById(R.id.buttonwidth);
    		widthButton.setOnClickListener(setWidthButtonListener);
    		
    		currentDialog.show();
    		return true;
    }
    
    public boolean showColorDialog(MenuItem menuItem) {
    	System.out.println(a+"--"+r+"--"+g+"--"+b);
    	
		currentDialog = new Dialog(this);
		currentDialog.setContentView(R.layout.color_dialog);
		currentDialog.setTitle(R.string.color_text);
		
		SeekBar alphaSeekBar = (SeekBar) currentDialog.findViewById(R.id.alpha_bar);
		SeekBar blueSeekBar = (SeekBar) currentDialog.findViewById(R.id.blue_bar);
		SeekBar redSeekBar = (SeekBar) currentDialog.findViewById(R.id.red_bar);
		SeekBar greenSeekBar = (SeekBar) currentDialog.findViewById(R.id.green_bar);
		alphaSeekBar.setOnSeekBarChangeListener(colorSeekBarListener);
		alphaSeekBar.setProgress(doodleView.a);
		blueSeekBar.setOnSeekBarChangeListener(colorSeekBarListener);
		blueSeekBar.setProgress(doodleView.b);
		redSeekBar.setOnSeekBarChangeListener(colorSeekBarListener);
		redSeekBar.setProgress(doodleView.r);
		greenSeekBar.setOnSeekBarChangeListener(colorSeekBarListener);
		greenSeekBar.setProgress(doodleView.g);
		
		ImageView imageView = (ImageView) currentDialog.findViewById(R.id.color_view);
		Bitmap bitmap = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
		Paint p = new Paint();
		p.setColor(Color.argb(doodleView.a,doodleView.r,doodleView.g,doodleView.b));
		imageView.setImageBitmap(bitmap);
		imageView.setBackgroundColor(Color.argb(doodleView.a,doodleView.r,doodleView.g,doodleView.b));
		
		Button colorButton = (Button) currentDialog.findViewById(R.id.set_color);
		colorButton.setOnClickListener(setColorButtonListener);
		
		currentDialog.show();
		return true;
    }
    
    private OnSeekBarChangeListener colorSeekBarListener = new OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			SeekBar alphaSeekBar = (SeekBar) currentDialog.findViewById(R.id.alpha_bar);
			SeekBar blueSeekBar = (SeekBar) currentDialog.findViewById(R.id.blue_bar);
			SeekBar redSeekBar = (SeekBar) currentDialog.findViewById(R.id.red_bar);
			SeekBar greenSeekBar = (SeekBar) currentDialog.findViewById(R.id.green_bar);
			ImageView imageView = (ImageView) currentDialog.findViewById(R.id.color_view);
			Paint p = new Paint();
			a = alphaSeekBar.getProgress();
			r = redSeekBar.getProgress();
			g = greenSeekBar.getProgress();
			b = blueSeekBar.getProgress();
			p.setColor(Color.argb(a,r,g,b));
			
			Bitmap bitmap = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
			imageView.setImageBitmap(bitmap);
			imageView.setBackgroundColor(Color.argb(a,r,g,b));
			System.out.println(a+"--"+r+"--"+g+"--"+b);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
    };
    
    private OnSeekBarChangeListener widthSeekBarListener = new OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			ImageView imageView = (ImageView) currentDialog.findViewById(R.id.imageviewwidth);
			
			Paint p = new Paint();
			p.setColor(Color.BLACK);
			
			Bitmap bitmap = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);
			canvas.drawCircle(125, 125, seekBar.getProgress(), p);
			imageView.setImageBitmap(bitmap);
		
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    private OnClickListener setWidthButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			SeekBar seekBar = (SeekBar) currentDialog.findViewById(R.id.seekbarwidth);
			
			// set the width
			doodleView.width = seekBar.getProgress();
			
			currentDialog.dismiss();
			currentDialog = null;
		}
    	
    };
    
    private OnClickListener setColorButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			SeekBar alphaSeekBar = (SeekBar) currentDialog.findViewById(R.id.alpha_bar);
			SeekBar blueSeekBar = (SeekBar) currentDialog.findViewById(R.id.blue_bar);
			SeekBar redSeekBar = (SeekBar) currentDialog.findViewById(R.id.red_bar);
			SeekBar greenSeekBar = (SeekBar) currentDialog.findViewById(R.id.green_bar);
			// set the width
			doodleView.a = alphaSeekBar.getProgress();
			doodleView.b = blueSeekBar.getProgress();
			doodleView.r = redSeekBar.getProgress();
			doodleView.g = greenSeekBar.getProgress();
			
			currentDialog.dismiss();
			currentDialog = null;
		}
    	
    };
    
    
    

}










