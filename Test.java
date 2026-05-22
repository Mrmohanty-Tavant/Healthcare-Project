package com.datastack.thehealthcare.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
	@GetMapping("/getFiles")
	public ResponseEntity<byte[]> getAllPatientById() throws IOException{
		
	      String fileURL = "https://eaiotsdev1-electrificationx-s3-dev.s3.eu-central-1.amazonaws.com/southbound-data/pam_%40HF/FCOV_AN2/nfo/gh456677/1715935161221.zip?response-content-disposition=attachment%3B%20filename%3D1715935161221.zip&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEGsaDGV1LWNlbnRyYWwtMSJGMEQCIDoA25BTFxuHhp1ZOqbRPOIo1aMdG5ji0aDIYUqpgCfCAiAihnW1dBZXwbbWd7yBoft0R7N9%2FQ4oCGkl3pHrFdJmrCqJBQjU%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDk1NTc2MTAwODI0NSIMjV7iENaieoPaI%2FH4Kt0EGg7GH9dCO5CNPUzoo6HQb6FQhUY%2F4qhNgmup44fu5K6SxnZQtupPOgeCdtLa8FuKbOyL3plkA8PWBLregrOy8xSWRNQ3qLX6yVtcGUKG2gdtd7PQRNZCr9i9diSbBkePhXPhzBdjgI%2FmhgQIUtsTUg6Iy8Sw2XEz4JhH0bCombed0umdwSWCB%2FJOG4vqksKQNQOy6QUO5X7EEtm8sXXy7OZoZrgTF1G9wDJIjcFRFetMQOeyZ8Kr9LcEmnQ5wzJAZqyqFjugGqi12E4yPbfBZu1%2F2VgWX7YXzo2nDhrjUFDAjcLroPTzk2kOeQIaQuSTOTmax8ndNC0K%2F1NmoN%2FjLxcOnE%2FVCji%2F7rhqKqJ3diKjyCP0CYigeiJvzWMV0SNzCFRKaHFJ3WoiK1kuA%2BDX%2BuQNnoqotJEWR9u5U8w3IJt4BKOhhVvWgLKZcWzawtt49OvN9kjPyVyD9jiZjPVm1neQ2UL9c4x%2F8QdAeB6LiJPyO1PT%2FPA%2BVvRVNajAMyek1%2BItxhRYzWjIvQMQrpiaMytP%2B2qLNmAJvSC3VcUMRJV7MKUiVG1oWlvpbaiw7iGt2WZNzGvlgopt8KwsQmOsmEB%2BIMAaVKESJnCFEQnz1v%2FxT3mNm4elQf%2FoxPmr9w%2BrCuHHC7syVN0b7C7hDqTO5QGpgQu9Jp40Fa6XFUYxnbi59UBjDncx7kYB2Lggse3ajWrXkGt0L9JpEcM3Yy%2BOUnA7eXeaXlimjrU37GjKyR%2BywJAu9NWpi8KZDttR%2FJ%2FsoJ30azo3A%2BI4WDMUCxMqkw4QWRQoi0pw76%2BS55gwg%2FScsgY6mwFWFn89vQTigwZaAT4n5Z%2B7t2Dhqyq4c%2FsRW5Q5xgtRw3KvlltfX%2BTF5BEd6W6EjbPdzbAqKgUB%2Fq9qjKHckGhCdemwjPXPlsdC8TUKPnFv19z%2FMneldfnoHfp5JVlFQ%2FdP8R8XlFvQzSTCXaw%2B1Kr4T1tvn9xzEsi%2FUqFeOLY6xm0WvtyTX7A0JgTFbSr%2BAWyne7t61XJVK29ang%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240517T111502Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIA55B6LTZ2UFQ6Q335%2F20240517%2Feu-central-1%2Fs3%2Faws4_request&X-Amz-Signature=8ef919f8bd88d9d89b67f86808c0fd37d9ad9e451d73e2e7f338d2ecd243b7c9";
	            byte[] zipBytes = downloadFileToByteArray(fileURL);
	            byte[] jsonContent=  parseArchiveFile(zipBytes);

		return new ResponseEntity<>(jsonContent, HttpStatus.OK);
	}
	  public static byte[] downloadFileToByteArray(String fileURL) throws IOException {
	        URL url = new URL(fileURL);
	        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
	        int responseCode = httpConnection.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            try (InputStream inputStream = httpConnection.getInputStream();
	                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
	                byte[] buffer = new byte[4096];
	                int bytesRead;
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	                return outputStream.toByteArray();
	            }
	        } else {
	            throw new IOException("Failed to download file: HTTP error code " + responseCode);
	        }
	    }
	    
	    public static byte[] parseArchiveFile(byte[] archiveFileContent) {
	        byte[] jsonFileContent = null;
	        try (InputStream inputStream = new ByteArrayInputStream(archiveFileContent);
	            BufferedInputStream bi = new BufferedInputStream(inputStream);
	        		ZipInputStream zis = new ZipInputStream(bi)) {
	            ZipEntry entry;
	            while ((entry = zis.getNextEntry()) != null) {
	              if (!entry.isDirectory()){
	                 jsonFileContent = IOUtils.toByteArray(zis);
	               
	              }
	            }
	        } catch (IOException e) {
	         
	           e.printStackTrace();
	        }
	        System.out.println(jsonFileContent);
	        return jsonFileContent;
	    }
	}

