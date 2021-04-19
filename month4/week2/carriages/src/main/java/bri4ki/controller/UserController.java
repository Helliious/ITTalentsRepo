package bri4ki.controller;


import bri4ki.exceptions.AuthenticationException;
import bri4ki.exceptions.BadRequestException;
import bri4ki.model.dto.LoginUserDto;
import bri4ki.model.dto.RegisterRequestUserDTO;
import bri4ki.model.dto.RegisterResponseUserDTO;
import bri4ki.model.dto.UserWithoutPassDTO;
import bri4ki.model.pojo.User;
import bri4ki.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionManager sessionManager;

    @PutMapping("/users/{user_id}/cars/{car_id}")
    public UserWithoutPassDTO buyCar(@PathVariable(name = "user_id") int userId, @PathVariable(name = "car_id") int carId, HttpSession ses){

        User loggedUser = sessionManager.getLoggedUser(ses);
        if(loggedUser.getId() != userId){
                throw new BadRequestException("You cannot buy a car on behalf of another user");
        }
        return userService.buyCar(userId, carId);
    }

    @PostMapping("/users")
    public UserWithoutPassDTO login(@RequestBody LoginUserDto dto, HttpSession ses){
        UserWithoutPassDTO responseDto = userService.login(dto);
        sessionManager.loginUser(ses, responseDto.getId());
        //service.login
        return responseDto;
    }

    @PostMapping("/logout")
    public void logout(HttpSession ses){
        sessionManager.logoutUser(ses);
    }

    @PutMapping("/users")
    public RegisterResponseUserDTO register(@RequestBody RegisterRequestUserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserWithoutPassDTO> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserWithoutPassDTO getById(@PathVariable int id){
        return userService.getUserById(id);
    }

}
