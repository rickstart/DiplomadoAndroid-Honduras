package com.mobintum.reviewsplaces;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Rick on 24/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Place {

    private String name;
    private String[] photos;
    private String description;
    private Date publishDate;
    private String publisherName;
    private String publisherPhoto;

    public Place(String name, String[] photos, String description, Date publishDate, String publisherName, String publisherPhoto) {
        this.name = name;
        this.photos = photos;
        this.description = description;
        this.publishDate = publishDate;
        this.publisherName = publisherName;
        this.publisherPhoto = publisherPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherPhoto() {
        return publisherPhoto;
    }

    public void setPublisherPhoto(String publisherPhoto) {
        this.publisherPhoto = publisherPhoto;
    }


    public static ArrayList<Place> getPlaces(){
        ArrayList<Place> places = new ArrayList<>();

        String[] arrayCozumel = {"http://pasaportea.iberostar.com/wp-content/uploads/2013/09/CAR_Cozumel.jpg",
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTAvvmMiMOCQjgIBBDnI-liE4D9KvQgK3fI_KxGnusj9LrS1sXfyw",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRrMp-IvgI-Kw0yE0OlkW3mm_im_RUTNEEx_SYkoBZwS4eTqF_Y",
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRnvA5SpQ8Xg-s1VSR4Yzb1Eq7i7A98xat0FexuSUzyeSqHFmxsUQ",
                "https://www.carnival.com/~/media/Images/PreSales/Excursions/Ports_A-F/CZM/304167/Pictures/Cozumel%20Chankanaab%20jpg.jpg"};
        String descriptionCozumel = "Cozumel (en yucateco: Kosom, Lumil, ‘Golondrina, Tierra de’‘Tierra de las golondrinas’)?, es una isla mexicana, la tercera más grande y la segunda más poblada del país. Se ubica al este de México, en el mar Caribe, a sesenta y dos kilómetros de Cancún y constituye (junto a los enclaves continentales Calica y Xel-Há) uno de los 11 municipios del estado de Quintana Roo";
        places.add(new Place("Cozumel México",arrayCozumel,descriptionCozumel,Calendar.getInstance().getTime(),"Ricardo Centeno", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/12662701_1000123373393170_6257234275068153647_n.jpg?oh=e573bea5de2eac8a43bafc5b8e587fe9&oe=58017A84"));

        String [] arrayEduardo={"http://lanoticia.hn/wp-content/uploads/2015/03/amapala1.jpg","http://cdn.latribuna.hn/wp-content/uploads/2015/05/AMAPALA-1.jpg","http://cdn.latribuna.hn/wp-content/uploads/2015/12/1-FACHADA-2.jpg"};
        String descripcionEduardo="Su nombre se debe a que en el siglo XVI operaba en la isla un grupo de piratas comandados por el pirata Francis Drake, él y sus hombres eran considerados por los habitantes de la zona como fieras salvajes y sanguinarios, por lo que llamaron a la isla -Cerro del Tigre-.\n" +
                "El nombre Amapala deriva del náhuatl y significa -cerca de los amates-, sin embargo hay otra versión que asegura que proviene de los vocablos ama (maíz) y palha (cerro) del dialecto de Goajiquiro, y por lo tanto significaría -cerro del maíz-";
        places.add(new Place("Amapala",arrayEduardo,descripcionEduardo, Calendar.getInstance().getTime(),"Eduardo Espino","https://avatars0.githubusercontent.com/u/20059600?v=3&u=703970eee66fce20cd64b89f87adfc553780f1e9&s=140"));

        String[] arrayOlvin = {
                "http://www.elheraldo.hn/csp/mediapool/sites/dt.common.streams.StreamServer.cls?STREAMOID=j1zefmYgzdVdnaam8j_i$8$daE2N3K4ZzOUsqbU5sYupEO7tPz$86cWVOv35R_yKWCsjLu883Ygn4B49Lvm9bPe2QeMKQdVeZmXF$9l$4uCZ8QDXhaHEp3rvzXRJFdy0KqPHLoMevcTLo3h8xh70Y6N_U_CryOsw6FTOdKL_jpQ-&CONTENTTYPE=image/jpeg",
                "https://c2.staticflickr.com/6/5542/12211554455_a543aca924_b.jpg",
                "http://eva.hn/wp-content/uploads/2014/04/sanlo.jpg",
                "http://eva.hn/wp-content/uploads/2013/10/dsc01713_te.jpg",
                "http://i150.photobucket.com/albums/s102/SAPtegus/San%20Lorenzo/SL3esculturacamaraon.jpg",
                "http://www.elheraldo.hn/csp/mediapool/sites/dt.common.streams.StreamServer.cls?STREAMOID=$l69eFZjrEIoKgMwzxoLVM$daE2N3K4ZzOUsqbU5sYv98xllTXKIck8zGAbeOVzdWCsjLu883Ygn4B49Lvm9bPe2QeMKQdVeZmXF$9l$4uCZ8QDXhaHEp3rvzXRJFdy0KqPHLoMevcTLo3h8xh70Y6N_U_CryOsw6FTOdKL_jpQ-&CONTENTTYPE=image/jpeg",
                "http://i150.photobucket.com/albums/s102/SAPtegus/San%20Lorenzo/SL2muellehistorico.jpg"
        };

        String descriptionOlvin="San Lorenzo es una ciudad relativamente joven, ya que a pesar de que los españoles " +
                "fundaron la aldea de San Lorenzo en 1522, no fue sino hasta el 1 de enero de 1912 cuando se crea el " +
                "municipio de San Lorenzo. San Lorenzo es caracterizado por la amabilidad de su gente, su amplia hospitalidad " +
                "y el espíritu emprendedor de sus ciudadanos. La ciudad ha crecido tanto, " +
                "que ya está en proceso un reordenamiento urbano.";

        places.add(new Place("San Lorenzo, Valle",arrayOlvin, descriptionOlvin ,Calendar.getInstance().getTime(),"Olvin A. García","http://gravatar.com/avatar/88a213bc1ac69344d61f5d4ff70f5f27?s=400"));


        String[] arrayMaurin = {"https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/12994515_1077541512321209_8427573704082146474_n.jpg?oh=0cc3895bcb4e85de422ed6e78afb88cb&oe=57C4D7E9", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/10922455_804685219606841_2811028863161443754_n.jpg?oh=6f9a6081a1537d595451b55bf7d1dd7f&oe=57ECC1F9", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/10527517_694380567303974_6470299431727390193_n.jpg?oh=2ba102aabeba2aaad0016da598cc74a6&oe=57F54F17"};
        String descripcion = "Atima es un municipio del departamento de Santa Bárbara de la República de Honduras " +
                "En sus cercanías existen verdaderas riquezas naturales con un gran potencial turístico, como la pared de piedra de unos trescientos metros de altura " +
                "y El conjunto de cuevas conocidas como las Cuevas de Pencaligue";

        places.add(new Place("Atima Santa Bárbara,Honduras", arrayMaurin, descripcion, Calendar.getInstance().getTime(), "Maurin Alcántara","https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/13344649_1357732067573917_2015319381161678062_n.jpg?oh=b1a54448cb76c70a89aa3f89776acb39&oe=58070457"));

        String[] arrayMiguel = {"http://eva.hn/wp-content/uploads/2013/04/Valle-de-%C3%81ngeles4.jpg",
                "http://eva.hn/wp-content/uploads/2013/04/Valle-de-%C3%81ngeles.jpg",
                "http://www.hundart.com/wp-content/uploads/2016/01/valle.jpg",
                "http://cdn.latribuna.hn/wp-content/uploads/2015/12/valle-angeles_1-770x470.jpg",
                "http://www.elheraldo.hn/csp/mediapool/sites/dt.common.streams.StreamServer.cls?STREAMOID=CYAqm_aa7bxnng6lluJlpc$daE2N3K4ZzOUsqbU5sYsvRiRv5B_Rdej$OEv8FPbXWCsjLu883Ygn4B49Lvm9bPe2QeMKQdVeZmXF$9l$4uCZ8QDXhaHEp3rvzXRJFdy0KqPHLoMevcTLo3h8xh70Y6N_U_CryOsw6FTOdKL_jpQ-&CONTENTTYPE=image/jpeg"};

        places.add(new Place("Valle de Angeles", arrayMiguel,"Pueblecito pequeno muy proximo a Tegucigalpa, rodeado de pinos que ultimamente se encuentra bajo ataque del gorgojo descortezador",Calendar.getInstance().getTime(),"Miguel Calderon","https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/10384673_1512308849031639_3624761729857182957_n.jpg?oh=5bcf55f06e0a03fdd1da24e98ebbce2d&oe=57FE9CE2"));

        String[] arrayIvan = {"http://cdn.latribuna.hn/wp-content/uploads/2015/08/hablamos-7.jpg","https://upload.wikimedia.org/wikipedia/commons/2/24/Talanga_road_Honduras.jpg","http://www.angelfire.com/ca5/mas/dpmapas/fmo/ced/me01.jpg","http://mw2.google.com/mw-panoramio/photos/medium/107138146.jpg","https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/1937412_10208350656309965_5246800272218790167_n.jpg?oh=18a3109d0bac847ff2f61c7491033434&oe=57FACD4F"};
        String descriptionIvan="Talanga es una ciudad situada en el departamento de Francisco Morazán, a unos 52 km (por carretera) desde Tegucigalpa (capital de Honduras),  cabecera del municipio homónimo. En el año 1981 fue nombrada oficialmente como ciudad. Sin embargo los primeros registros de población se remontan al año de 1791, cuando aparece formando parte del Curato de Cantarranas. En 1829 fue declarado como municipio por Don Pedro de Alvarado.\n" +
                "Su nombre significa Lugar de lodo o Lugar de fango\". En el año 2001 la población urbana del municipio era de aproximadamente de 15,000 habitantes, sin embargo el municipio cuenta con más de 35.000 habitantes. Sus calles son de tierra. La única calle asfaltada es la calle principal que inicia al final del boulevard de Talanga la cual no ha sido concluida hasta su objetivo.";

        places.add(new Place("Municipio de Talanga",arrayIvan,descriptionIvan, Calendar.getInstance().getTime(),"ivalle","https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/381877_10150501232928928_527912273_n.jpg?oh=ce3375a8d48a0d238a98b037a8986926&oe=580AE78E"));
        return places;
    }
}
