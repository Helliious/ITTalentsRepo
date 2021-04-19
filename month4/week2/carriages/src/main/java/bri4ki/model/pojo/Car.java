package bri4ki.model.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String color;
    private int year;
    private int km;

    @ManyToOne
    @JoinColumn(name="owner_id")
    @JsonBackReference
    private User owner;

    @OneToMany(mappedBy = "car")
    @JsonManagedReference
    private List<CarImage> images;

    @ManyToMany(mappedBy = "likedCars")
    @JsonBackReference
    private List<User> likers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/*
    {
        "model" : "mazda",
        "km" : 123000,
        "owner" : {
            "id":1,
            "username" : "krasi",
            "address" : "sofia"
        }


    }


 */