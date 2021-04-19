package bri4ki.controller;

import bri4ki.exceptions.AuthenticationException;
import bri4ki.exceptions.BadRequestException;
import bri4ki.exceptions.NotFoundException;
import bri4ki.model.dto.CarWithoutOwnerDTO;
import bri4ki.model.pojo.Car;
import bri4ki.model.pojo.User;
import bri4ki.model.repository.CarRepository;
import bri4ki.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class CarController extends AbstractController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionManager sessionManager;

    @GetMapping("/cars/{id}")
    public CarWithoutOwnerDTO getById(@PathVariable int id){
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) {
            return new CarWithoutOwnerDTO(car.get());
        }
        else{
            throw new NotFoundException("Car not found");
        }
    }

    @PostMapping("/cars/{id}")
    public CarWithoutOwnerDTO like(@PathVariable int id, HttpSession ses){
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) {
            User u = sessionManager.getLoggedUser(ses);
            if(u.getLikedCars().contains(car.get())){
                throw new BadRequestException("Car already liked");
            }
            else {
                u.getLikedCars().add(car.get());
                userRepository.save(u);
            }
            return new CarWithoutOwnerDTO(carRepository.findById(id).get());
        }
        else{
            throw new NotFoundException("Car not found");
        }
    }

}
