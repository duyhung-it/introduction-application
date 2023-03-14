package com.duyhung.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "UploadFile",value = {"/upload-file"})
@MultipartConfig
public class UploadFile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file-poster");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File uploads = new File("D:\\FPT Polytechnic\\Servlet_JSP\\Practice\\IntroductionApplication\\src\\main\\resources\\META-INF\\uploads");
        File file = new File(uploads,fileName);
        if(!file.exists()) file.mkdir();
        part.write(file.getAbsolutePath());
    }
}
