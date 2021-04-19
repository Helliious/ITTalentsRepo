package com.ittalents.demo.controller;

import com.ittalents.demo.model.Employee;
import com.ittalents.demo.model.File;
import com.ittalents.demo.model.Project;
import com.ittalents.demo.repository.EmployeeRepository;
import com.ittalents.demo.repository.FileRepository;
import com.ittalents.demo.repository.ProjectRepository;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @PostMapping("upload")
    public File uploadFile(@RequestPart MultipartFile file) throws IOException {
        //path can be constant
        java.io.File f = new java.io.File("D:\\Git\\SpringDemo\\assets" + java.io.File.separator + System.currentTimeMillis() + ".png");
        OutputStream os = new FileOutputStream(f);
        os.write(file.getBytes());
        File fileEntity = new File();
        fileEntity.setUrl(f.getPath());
        fileEntity.setEmployee(employeeRepository.findById(1).get());//to logged user
        fileRepository.save(fileEntity);
        return fileEntity;
    }

    @GetMapping(value = "files/{id}", produces = "image/*")
    public byte[] downloadFile(@PathVariable int id) throws IOException {
        File fileEntity = fileRepository.findById(id).get();
        java.io.File f = new java.io.File(fileEntity.getUrl());
        return Files.readAllBytes(f.toPath());
    }
}
