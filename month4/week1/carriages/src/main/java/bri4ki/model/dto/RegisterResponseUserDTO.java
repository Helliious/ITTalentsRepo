package bri4ki.model.dto;

import bri4ki.model.pojo.Car;
import bri4ki.model.pojo.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Component
public class RegisterResponseUserDTO {

    private int id;
    private String username;
    private int age;
    private String address;
    private String email;
    List<Car> cars;

    public RegisterResponseUserDTO(User user){
        id = user.getId();
        username = user.getUsername();
        age = user.getAge();
        address = user.getAddress();
        email = user.getEmail();
        cars = user.getCars();
    }
}
