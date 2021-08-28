package com.pangbai.galdev;
 
import android.app.Activity;
import com.onscripter.ONScripterView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText ab;
    @Override
    public void onClick(View p1) {
		//Toast.makeText(getApplication(), ab.getText().toString(), Toast.LENGTH_SHORT).show();

		 Intent myi=  new Intent(this,play.class);

		// String  ag=ab.getText().toString();
		 
		//myi.putExtra("share", ag);
	 startActivity(myi); 
	 finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		findViewById(R.id.activitymainButton1).setOnClickListener(this);

		

    }
}
