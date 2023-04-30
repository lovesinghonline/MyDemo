package com.example.MyDemo.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.ion.IonException;

import java.io.IOException;

@Service
public class FileService {

    public boolean uploadFile(MultipartFile file) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAUFNZ5BCOPC44M5TQ","XkrJuRS3GNkG9C1dIJbUNe+qqaCXSlm9hOdQLlEH");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
        try {
            ObjectMetadata metadata= new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            s3.putObject("lovebucketbackend", file.getOriginalFilename(), file.getInputStream(),metadata);
            return true;
        } catch (AmazonServiceException | IOException e) {
            return false;
    }

}
public S3Object getFile(String key){
    BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAUFNZ5BCOPC44M5TQ","XkrJuRS3GNkG9C1dIJbUNe+qqaCXSlm9hOdQLlEH");

    final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
return s3.getObject("lovebucketbackend",key);
}
public void deleteFile(String key){
    BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAUFNZ5BCOPC44M5TQ","XkrJuRS3GNkG9C1dIJbUNe+qqaCXSlm9hOdQLlEH");

    final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
   s3.deleteObject("lovebucketbackend",key);
}
}
