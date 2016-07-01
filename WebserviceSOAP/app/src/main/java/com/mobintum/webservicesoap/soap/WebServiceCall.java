package com.mobintum.webservicesoap.soap;

import android.util.Log;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Rick on 30/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class WebServiceCall {
    private static final String TAG = WebServiceCall.class.getSimpleName();

    public static InputStream callWSThreadSoapPrimitive(String strURL, String strSoapAction, SoapObject request) {

        try {
            StringBuffer result;
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(strURL);
            ht.debug = true;
            ht.call(strSoapAction, envelope);

            Log.d(TAG, "result: " + envelope.getResponse().toString());
            SoapObject response = (SoapObject) envelope.getResponse();
            result = new StringBuffer(response.toString());


            StringBuffer resultString=new StringBuffer(ht.responseDump.toString());
            Log.d("XML data ",resultString.toString());

            InputStream stream = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                stream = new ByteArrayInputStream((ht.responseDump.getBytes(StandardCharsets.UTF_8)));
            }

            return stream;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
