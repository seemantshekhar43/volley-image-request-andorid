package comandydevo.wixsite.seemantshekhar43.volleyimagerequest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;


    /* paste the following in gradle(Module:app) in dependencies
        "compile 'com.android.volley:volley:1.0.0'"
    */

    /* paste the following in AndroidManifest.xml
        <uses-permission android:name="android.permission.INTERNET"/>
     */
    /* create a new file in java
            MySingleton
     */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define a string holding the url which we have to display
        final String myUrl = "http://i.dawn.com/primary/2015/05/554da653324dd.jpg?r=1450620599";

        // introduce image view and button

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.button);

        //make the button listen

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*call the method imagerequest parameter needed
               (url, response listener, max width, max height,config,error listener)
                   */
                ImageRequest imageRequest = new ImageRequest(myUrl,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {

                                // viewing the image on screen
                                imageView.setImageBitmap(response);
                            }
                        }, 0, 0, null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                               // lets watch the error if any
                                Log.i("Error","Error");
                            }
                        });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(imageRequest);
            }
        });

    }
}
