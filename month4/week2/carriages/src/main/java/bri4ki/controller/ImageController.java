package bri4ki.controller;

import bri4ki.model.pojo.Car;
import bri4ki.model.pojo.CarImage;
import bri4ki.model.repository.CarImageRepository;
import bri4ki.model.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

@RestController
public class ImageController {

    @Value("${file.path}")
    private String filePath;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarImageRepository carImageRepository;

    @PutMapping("/cars/{id}/images")
    public CarImage upload(@PathVariable int id, @RequestPart MultipartFile file) throws IOException {
        //create a phisical file -> java.io.File
        File pFile = new File(filePath + File.separator + id+"_"+System.nanoTime() +".png");
        //write all bytes from the multipartfile
        OutputStream os = new FileOutputStream(pFile);
        os.write(file.getBytes());
        //create a CarImage object
        CarImage carImage = new CarImage();
        //set its url to the path of the phisical file
        carImage.setUrl(pFile.getAbsolutePath());
        carImage.setCar(carRepository.findById(id).get());
        //save carImage object
        carImageRepository.save(carImage);
        //return carImage object
        os.close();
        return carImage;
    }

    @GetMapping(value = "/images/{id}", produces = "image/*")
    public byte[] download(@PathVariable int id) throws IOException {
        //find the carImage object from db, extract its url
        CarImage carImage = carImageRepository.findById(id).get();
        //get the phisical file from the url
        String url = carImage.getUrl();
        File pFile = new File(url);
        //read its bytes and write them into response body
        return Files.readAllBytes(pFile.toPath());
    }
}
