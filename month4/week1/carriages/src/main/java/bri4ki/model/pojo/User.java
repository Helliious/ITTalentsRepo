package bri4ki.model.pojo;

import bri4ki.model.dto.RegisterRequestUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private int age;
    private String address;
    @OneToMany(mappedBy = "owner")
    List<Car> cars;

    public User(RegisterRequestUserDTO userDTO){
        username = userDTO.getUsername();
        password = userDTO.getPassword();
        email = userDTO.getEmail();
        age = userDTO.getAge();
        address = userDTO.getAddress();
    }

    /*
        {
            "id" : 1,
            "username" : "krasi",
            ...
            "cars" : [
                {
                    "id" : 1,
                    "model" : "opel"
                }

            ]


        }




     */

}
