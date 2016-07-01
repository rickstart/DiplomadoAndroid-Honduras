package com.mobintum.webservicesoap;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.mobintum.webservicesoap.models.Nacionalidad;
import org.ksoap2.serialization.SoapObject;
import java.util.ArrayList;

/**
 * Created by Rick on 30/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class SOAPAsynTask  extends AsyncTask<String, Void, ArrayList<Nacionalidad>> {

    public final static String SOAP_ACTION = "http://tempuri.org/";
    public final static String NAME_SPACE = "http://tempuri.org/";
    public final static String URL = "http://190.185.112.186/WebServices/GV_DGME_MOVIL_WS/movil.asmx";
    public final static String MOV_CARGAR_NACIONALIDADES = "MOV_CargarNacionalidades";
    public final static String NACIONALIDADES_SOAP_ACTION =  SOAP_ACTION+MOV_CARGAR_NACIONALIDADES;

    private Activity activity;
    private String[] paramsName;
    private AsyncCallback listener;


    public SOAPAsynTask(Activity activity, String[] paramsName, AsyncCallback listener) {
        this.activity = activity;
        this.paramsName = paramsName;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected ArrayList<Nacionalidad> doInBackground(String... params) {
        //create a new soap request object
        SoapObject request = new SoapObject(NAME_SPACE,MOV_CARGAR_NACIONALIDADES);
        //add properties for soap object
        request.addProperty(paramsName[0], params[0]);
        request.addProperty(paramsName[1], params[1]);

        //request to server and get Soap Primitive response
        return WebServiceCall.callWSThreadSoapPrimitive(URL, NACIONALIDADES_SOAP_ACTION, request);
    }

    @Override
    protected void onPostExecute(ArrayList<Nacionalidad> nacionalidades) {
        super.onPostExecute(nacionalidades);
        if (nacionalidades == null) {
            Log.e("DEBUG", "ERROR");
        } else {
            Log.e("DEBUG", "s");
            listener.setResponse(nacionalidades);
        }
    }


    public interface AsyncCallback{
        public void setResponse(ArrayList<Nacionalidad> response);
    }

}
