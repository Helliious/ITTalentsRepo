package bri4ki.model.dto;

import bri4ki.model.pojo.Car;
import bri4ki.model.pojo.CarImage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Component
public class CarWithoutOwnerDTO {

    private int id;
    private String model;
    private String color;
    private int year;
    private int km;
    private int likes;
    private List<CarImage> images;

    public CarWithoutOwnerDTO(Car car){
        id = car.getId();
        model = car.getModel();
        color = car.getColor();
        year = car.getYear();
        km = car.getKm();
        images = car.getImages();
        likes = car.getLikers().size();
    }
}
