package com.pangbai.galdev;
 
import android.app.Activity;
import com.onscripter.ONScripterView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import android.util.Log;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import android.content.res.AssetManager;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.os.Environment;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText ab;
	String TAG = "拷贝文件";
    @Override
    public void onClick(View p1) {
		
		Toast.makeText(getApplication(), ab.getText().toString(), Toast.LENGTH_SHORT).show();

		 Intent myi=  new Intent(this,play.class);

		 String  ag=ab.getText().toString();
		 
		myi.putExtra("share", ag);
	 startActivity(myi); 
	 finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		findViewById(R.id.activitymainButton1).setOnClickListener(this);
    ab=findViewById(R.id.activitymainEditText1);
		copyFileOrDir("gal") ;
		Toast.makeText(getApplication(), "执行完毕", Toast.LENGTH_SHORT).show();

    }
	
	
	/**
     * 从assets目录下拷贝整个文件夹，不管是文件夹还是文件都能拷贝
     * 
     * @param context
     *            上下文
     * @param rootDirFullPath
     *            文件目录，要拷贝的目录如assets目录下有一个SBClock文件夹：SBClock
     * @param targetDirFullPath
     *            目标文件夹位置如：/sdcrad/SBClock
     */
	private void copyFileOrDir(String path) {
		AssetManager assetManager = this.getAssets();
		Toast.makeText(getApplication(), "执行中", Toast.LENGTH_SHORT).show();
		String assets[] = null;

		try {
			assets = assetManager.list(path);

//复制单个文件

			if (assets.length == 0)

			{
				copyFile(path);

			}

//复制文件夹中的文件到另一个目录中

			else

			{
				for (int i = 0; i < assets.length; ++i)

				{
					Log.e("Path",path + "/" + assets[i]);

					copyFileOrDir(path + "/" + assets[i]);

				}

			}

		} catch (IOException ex) {
			Log.e("tag", "I/O Exception", ex);

		}

	}

	private void copyFile(String filename) {
		AssetManager assetManager = this.getAssets();

		InputStream in = null;

		OutputStream out = null;

		try {
			in = assetManager.open(filename);

			String newFileName = "/data/data/"+getPackageName() +"/files/"+filename;

			Log.e("here",newFileName);

			out = new FileOutputStream(newFileName);

			byte[] buffer = new byte[1024];

			int read;

			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);

			}

			in.close();

			in = null;

			out.flush();

			out.close();

			out = null;

		} catch (Exception e) {
			Log.e("copyFile", e.getMessage());

		}

	}
	
}
