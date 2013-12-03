package com.example.day1;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button button;
	private ImageButton imgbutton;
	private TextView txtview;
	private Button button2;
	private EditText edittext;
	private Button logbutton;
	
	private int touchCount = 0;

	private ImageView imageview;
	private boolean changeImage = true;
	private String imgPath = "";
	
	private Button button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			logbutton = (Button) findViewById(R.id.button4);
			logbutton.setOnClickListener(this);
			
			button = (Button) findViewById(R.id.button1);
			button.setOnClickListener(this);
			
			imgbutton = (ImageButton) findViewById(R.id.imageButton1);
			imgbutton.setOnClickListener(this);
			
			txtview = (TextView) findViewById(R.id.textView1);
			
			button2 = (Button) findViewById(R.id.button2);
			button2.setOnClickListener(this);
			
			edittext = (EditText) findViewById(R.id.editText1);
			
			imageview = (ImageView) findViewById(R.id.imageView1);
			
			button3 = (Button) findViewById(R.id.button3);
			button3.setOnClickListener(this);
		}
		catch (Exception e)	{
			Log.e("err", "oncreate_view_connect problem");
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			try {
				Toast.makeText(MainActivity.this, "Textview1을 getText로 가져온 값 : "
												+txtview.getText().toString()+"", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				Log.e("err", "button(1)_gettext_txtview problem");
				e.printStackTrace();
			}
			break;
		case R.id.imageButton1:
			try {
				++touchCount;
				txtview.setText(touchCount+" 눌림!");
				Toast.makeText(MainActivity.this, "이미지 버튼 눌림", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {	
				Log.e("err", "imgbutton(1)_plus_touchcount problem");
				e.printStackTrace();
			}
			break;
		case R.id.button2:
			try {
				Toast.makeText(MainActivity.this, "입력란을 getText로 가져온 값 : "
					+edittext.getText().toString()+"", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				Log.e("err", "button(2)_get_edittext problem");
				e.printStackTrace();
			}
			break;
		case R.id.button3:
			try{
				if (changeImage) {
					changeImage = false;
					imgPath = "gyunbin.jpg";
				} else {
					changeImage = true;
					imgPath = "singer.jpg";
				}
				
				InputStream ims;
				ims = getAssets().open(imgPath);
				Drawable d = Drawable.createFromStream(ims, null);
				Toast.makeText(MainActivity.this, imgPath, Toast.LENGTH_SHORT).show();
				// 이미지 뷰에 표시해줍니다.
				imageview.setImageDrawable(d);
			} catch (IOException ioe) {
				// exception for inputstream
				
				Log.e("IO err","ims problem!");
				ioe.printStackTrace();
				
			} catch (Exception e) {
				Log.e("err", "button(3)_change_imgview problem");
				e.printStackTrace();
			}
			break;
		case R.id.button4:
			Log.i("info", "Logcat Print!");
			
			break;
		}
		
		// TODO Auto-generated method stub
	}

}
