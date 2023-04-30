package com.example.MyDemo.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.MyDemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileResource {
    @Autowired
    private FileService fileService;
    @PostMapping
    public boolean uploadFile(@RequestParam(name = "file")MultipartFile file){
        return fileService.uploadFile(file);
    }
@GetMapping
    public void view(@RequestParam(name ="key") String key, HttpServletResponse response) throws IOException {
    S3Object objet= fileService.getFile(key);
    response.setContentType(objet.getObjectMetadata().getContentType());
    response.getOutputStream().write(objet.getObjectContent().readAllBytes());

}
@GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam(name="key") String key) throws IOException {
       S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION,"attachment;filename=\""+key+"\"" )
                .body(object.getObjectContent().readAllBytes());

}
@DeleteMapping
    public void delete(@RequestParam(name="key")String key){
        fileService.deleteFile(key);
}
}
