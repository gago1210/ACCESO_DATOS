package modelo;

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

public class Alumno implements Serializable{
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

    @BsonProperty("calificaation")
        private double calificaation;

    @BsonProperty("higherGrade")
        private String higherGrade;

    @BsonProperty("FCTs")
        private boolean FCTs;

    //public Usuario (String id, double rating, int age; String name, String gender, String email, String phone, double calificaation, String higherGrade, boolean FCTs)


    @Override
    public String to String(){
        return Alumno(" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", calificaation=" + calificaation +
                ", higherGrade='" + higherGrade + '\'' +
                ", FCTs=" + FCTs );
    }
}
