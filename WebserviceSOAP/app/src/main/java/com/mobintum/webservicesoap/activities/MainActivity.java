package com.mobintum.webservicesoap.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mobintum.webservicesoap.R;
import com.mobintum.webservicesoap.soap.SOAPAsynTask;
import com.mobintum.webservicesoap.models.Nacionalidad;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SOAPAsynTask.AsyncCallback {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        invokeAsyncTask();
    }

    //create and execute asynctask to get response from W3school server
    private void invokeAsyncTask() {
        new SOAPAsynTask(MainActivity.this,new String[]{"usuario","password"}, SOAPAsynTask.MOV_CARGAR_NACIONALIDADES, this).execute("policia","12345");
    }

    @Override
    public void setResponse(InputStream response) {
        ArrayList<Nacionalidad> nacionalidades = parseXMLNacionalidad(response);
        if(nacionalidades!=null) {
            for (Nacionalidad nacionalidad : nacionalidades) {
                textView.append(nacionalidad.getNombre() + " " + nacionalidad.getCodigo() + "\n");
            }
        }
    }

    public static ArrayList<Nacionalidad> parseXMLNacionalidad(InputStream stream){
        ArrayList<Nacionalidad> nacionalidades = null;
        try {
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser parser = xmlFactoryObject.newPullParser();
            parser.setInput(stream, null);
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
