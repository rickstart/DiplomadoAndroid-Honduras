package com.mobintum.webservicesoap;

import android.util.Log;
import android.util.Xml;

import com.mobintum.webservicesoap.models.Nacionalidad;

import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by Rick on 30/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class WebServiceCall {
    private static final String TAG = WebServiceCall.class.getSimpleName();

    public static ArrayList<Nacionalidad> callWSThreadSoapPrimitive(String strURL, String strSoapAction, SoapObject request) {

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
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myParser = xmlFactoryObject.newPullParser();
            InputStream stream = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                stream = new ByteArrayInputStream((ht.responseDump.getBytes(StandardCharsets.UTF_8)));
            }
            myParser.setInput(stream, null);
            ArrayList<Nacionalidad> nacionalidades = parseXMLNacionalidad(myParser);

            return nacionalidades;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Nacionalidad> parseXMLNacionalidad(XmlPullParser parser){
        ArrayList<Nacionalidad> nacionalidades = null;
        try {
            int eventType = parser.getEventType();
            int i = 0;
            Nacionalidad currentNacionalidad = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = null;
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        nacionalidades = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        if (name.equals("nacionalidad")) {
                            currentNacionalidad = new Nacionalidad();

                        } else if (currentNacionalidad != null) {
                            if(name.equals("codigo")){
                                currentNacionalidad.setCodigo(parser.nextText());
                            } else if (name.equals("nombre")){
                                currentNacionalidad.setNombre(parser.nextText());
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase("nacionalidad") && currentNacionalidad != null){
                            nacionalidades.add(currentNacionalidad);
                            currentNacionalidad = null;
                        }
                        break;
                }
                eventType = parser.next();
                i++;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return nacionalidades;
    }

}
