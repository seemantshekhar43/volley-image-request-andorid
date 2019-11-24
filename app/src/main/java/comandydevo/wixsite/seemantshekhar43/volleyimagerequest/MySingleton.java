package comandydevo.wixsite.seemantshekhar43.volleyimagerequest;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by A_Devy on 11/15/2017.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mContext;

    private MySingleton(Context context){
        mContext = context;
        requestQueue = getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getInstance(Context context){
        if (mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }
    public void addToRequestQueue(Request request){ requestQueue.add(request);}

}
