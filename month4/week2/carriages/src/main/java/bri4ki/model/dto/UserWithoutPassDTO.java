package bri4ki.model.dto;

import bri4ki.model.pojo.Car;
import bri4ki.model.pojo.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@Setter
@Getter
public class UserWithoutPassDTO {

    private int id;
    private String username;
    private String email;
    private int age;
    private String address;
    List<CarWithoutOwnerDTO> cars;
    List<CarWithoutOwnerDTO> likedCars;

    public UserWithoutPassDTO(User u){
        id = u.getId();
        username = u.getUsername();
        email = u.getEmail();
        age = u.getAge();
        address = u.getAddress();
        cars = new ArrayList<>();
        for(Car c : u.getCars()){
            cars.add(new CarWithoutOwnerDTO(c));
        }
        likedCars = new ArrayList<>();
        for(Car c : u.getLikedCars()){
            likedCars.add(new CarWithoutOwnerDTO(c));
        }
    }
}
