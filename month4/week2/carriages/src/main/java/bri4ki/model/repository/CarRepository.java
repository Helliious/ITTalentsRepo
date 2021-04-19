package bri4ki.model.repository;

import bri4ki.model.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    /*
        String sql = "SELECT * FROM users";
        if(name != null){
            sql += " WHERE username LIKE ?";
        }
        if(ageFrom != null && ageTo != null){
            sql += "AND age BETWEEN ? and ?"
        }

        //1- select * from users;
        //2- select * from users where name like ?
        //3- select * from users where age between ? and ?
        //4- select * from users where name like ? AND age between ? and ?


     */
    List<Car> findAllByOwner_IdNull();
}
