package com.mobintum.exercisethreelistzoo;
import java.util.ArrayList;
/**
 * Created by Rick on 23/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Animal {
    private String name;
    private String photo;

    public Animal(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static ArrayList<Animal> getAnimals(){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Giraffe", "http://assets.inhabitat.com/wp-content/blogs.dir/1/files/2014/12/Giraffe-Mother-and-Child.jpg"));
        animals.add(new Animal("Elephant", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0gVZHE7yAXM7rlSq8tU1SmlgatKB2kyFhO0Up9wN2wVIug0H8"));
        animals.add(new Animal("Lion", "http://cbs.umn.edu/sites/cbs.umn.edu/files/public/african_lion_king-wide_1.jpg"));
        animals.add(new Animal("Zebra", "https://aos.iacpublishinglabs.com/question/aq/700px-394px/sound-zebra-make_501cffc106c45b1b.jpg?domain=cx.aos.ask.com"));
        animals.add(new Animal("Shark", "http://cdn.newsapi.com.au/image/v1/external?url=http%3A%2F%2Fvideomam.news.com.au.s3.amazonaws.com%2Fgenerated%2Fprod%2F05%2F06%2F2015%2F29717%2Fimage1024x768.jpg%3Fcount%3D5&width=650&api_key=kq7wnrk4eun47vz9c5xuj3mc"));
        return animals;


    }
}
