package com.example.day1;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
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
	
	private int touchCount = 0;

	private ImageView imageview;
	private boolean changeImage = true;
	private String imgPath = "";
	
	private Button button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
			Toast.makeText(MainActivity.this, "Textview1을 getText로 가져온 값 : "
												+txtview.getText().toString()+"", Toast.LENGTH_SHORT).show();
			break;
		case R.id.imageButton1:
			++touchCount;
			txtview.setText(touchCount+" 눌림!");
			Toast.makeText(MainActivity.this, "이미지 버튼 눌림", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button2:
			Toast.makeText(MainActivity.this, "입력란을 getText로 가져온 값 : "
					+edittext.getText().toString()+"", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button3:
			if (changeImage) {
				changeImage = false;
				imgPath = "gyunbin.jpg";
			} else {
				changeImage = true;
				imgPath = "singer.jpg";
			}
			
			InputStream ims;
			try {
				ims = getAssets().open(imgPath);
				Drawable d = Drawable.createFromStream(ims, null);
				Toast.makeText(MainActivity.this, imgPath, Toast.LENGTH_SHORT).show();
				// 이미지 뷰에 표시해줍니다.
				imageview.setImageDrawable(d);
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		}
		// TODO Auto-generated method stub
	}

}
