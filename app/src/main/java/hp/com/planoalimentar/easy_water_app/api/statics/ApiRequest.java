package hp.com.planoalimentar.easy_water_app.api.statics;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import hp.com.planoalimentar.easy_water_app.auth.LoginActivity;
import hp.com.planoalimentar.easy_water_app.store.preferences.StorePreferences;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 10/10/2020.
 */
public class ApiRequest {

    private static StorePreferences storePreferences;
    private static String invalidToken = "Invalid token";
    private static String expredToken = "Token Expired";

   /**
    * This method make a post request to the server
    *
    * */
    public static void makePOSTRequest (final Context context, final String url, JSONObject jsonObject,
                                 final CallBack callback){

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, jsonObject, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if(callback!=null) {
                            callback.responce(response.toString());
                            try {
                                if(response.getString("message").equals(invalidToken) || response.getString("message").equals(expredToken)) {
                                    storePreferences.forceLoggout();
                                    Intent intent = new Intent(context, LoginActivity.class);
                                    context.startActivity(intent);
                                }
                            }catch (Exception $exception){
                                $exception.printStackTrace();
                                Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(callback!=null) {
                    callback.responce(error.toString());

                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map <String, String> getHeaders() throws AuthFailureError {
                HashMap <String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer "+storePreferences.getToken());
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjReq);
    }

    public static void makeGETRequest (final Context context, final String url, JSONObject jsonObject,
                                        final CallBack callback){

        storePreferences = new StorePreferences(context);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                if(callback!=null) {
                    callback.responce(response.toString());
                    try {
                        if(response.getString("message").equals(invalidToken) || response.getString("message").equals(expredToken)) {
                            storePreferences.forceLoggout();
                            Intent intent = new Intent(context, LoginActivity.class);
                            context.startActivity(intent);
                        }
                    }catch (Exception $exception){
                        $exception.printStackTrace();
                        Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(callback!=null) {
                    callback.responce(error.toString());
                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map <String, String> getHeaders() throws AuthFailureError {
                HashMap <String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer "+storePreferences.getToken());
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjReq);
    }

    public static void makePOSTLogin (final Context context, final String url, JSONObject jsonObject,
                                        final CallBack callback){

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                if(callback!=null) {
                    callback.responce(response.toString());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(callback!=null) {
                    callback.responce(error.toString());
                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map <String, String> getHeaders() throws AuthFailureError {
                HashMap <String, String> headers = new HashMap<String, String>();
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjReq);
    }

}
