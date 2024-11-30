package modelo;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.ioSerializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Profesor implements Serializable {
    @BsonProperty("id")
        private String id;
    @BsonProperty("rating")
        private double rating;

    @BsonProperty("age")
        private int age;

    @BsonProperty("name")
        private String name;

    @BsonProperty("gender")
        private String gender;

    @BsonProperty("email")
        private String email;

    @BsonProperty("phone")
        private String phone;

    @BsonProperty("subjects")
        private ArrayList<String> subjects;

    @BsonProperty("title")
        private String title;

    //public Usuario (String id, double rating, int age; String name, String gender, String email, String phone, ArrayList<String>subjects, String title)


    @Override
    public String to String(){
        return Profesor(" +
                "id='" + id + '\'' +
                        ", rating=" + rating +
                        ", age=" + age +
                        ", name='" + name + '\'' +
                        ", gender='" + gender + '\'' +
                        ", email='" + email + '\'' +
                        ", phone='" + phone + '\'' +
                        ", subjects=" + subjects +
                        ", title='" + title);
    }
}
