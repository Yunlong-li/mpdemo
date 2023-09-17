package com.example.mpdemo.api;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 图片下载测试类
 * @date 2023-08-23 21:56:02
 */

@RestController
@Log4j2
@RequestMapping("/test")
public class ImgDownloadController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/download")
//    public ResponseEntity<InputStreamResource> downloadImage(String imageUrl) {
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        try {
//            UrlResource imageResource = (UrlResource) resourceLoader.getResource(imageUrl);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//            headers.add("Pragma", "no-cache");
//            headers.add("Expires", "0");
//            return ResponseEntity.ok()
//                    .headers(headers)
//                    .contentLength(imageResource.contentLength())
//                    .contentType(MediaType.IMAGE_JPEG)
//                    .body(new InputStreamResource(imageResource.getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().build();
//        }
//    }
//    public byte[] downloadImage(String imageUrl) throws IOException {
//        InputStream in = new URL(imageUrl).openStream();
//
//        // You can modify this to save the image to a specific location if needed
//        Path tempFile = Files.createTempFile("temp-image", ".png");
//        Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
//
//        // Read the image bytes and return as response
//        byte[] imageBytes = Files.readAllBytes(tempFile);
//        return imageBytes;
//    }

//    public ResponseEntity<byte[]> downloadImage(String imageUrl) throws IOException {
////        String imageUrl = "https://nlp-eb.cdn.bcebos.com/logo/logoErnieBot.png"; // Replace with your image URL
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Make a request to the image URL and get the image bytes
//        ResponseEntity<byte[]> response = restTemplate.getForEntity(imageUrl, byte[].class);
//
//        // Set the appropriate headers for image download
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_PNG);
//        headers.setContentLength(response.getBody().length);
//        headers.setContentDisposition(ContentDisposition.attachment().filename("image.png").build());
//
//        return new ResponseEntity<>(response.getBody(), headers, HttpStatus.OK);
//    }


//    @PostMapping("/savaFile")
//    public void savaFile(byte[] bytes, int len) throws IOException {
//        // 输出文件
//        File outputFile = new File("D:\\桌面文件\\文本\\秋招\\开发\\后端\\mpdemo\\src\\main\\resources\\static\\照片流测试.png");
//        FileOutputStream fos = new FileOutputStream(outputFile);
//        fos.write(bytes, 0, len);
//        fos.close();
//    }


    // 接受文件流，并保存
    @PostMapping("/saveFile")
    public void savaFile(@RequestParam("file") MultipartFile file, Map<Object, String> params) throws IOException {
        System.out.println(params);
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            File outputFile = new File("D:\\桌面文件\\文本\\秋招\\开发\\后端\\mpdemo\\src\\main\\resources\\static\\照片流测试.png"); // 替换为实际的文件路径
            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(bytes);
            fos.close();
        }
    }


    @GetMapping("/downloadImage")
    public ResponseEntity<Object> downloadImage(@RequestParam("imageName") String imageName) throws IOException {
        String imagePath = imageName;

        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 读取图片内容
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(imageFile.toPath()));

        // 编码文件名
        String encodedFileName = URLEncoder.encode(imageName, StandardCharsets.UTF_8.toString());

        // 设置响应头，指定文件名和 Content-Disposition 为附件
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encodedFileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }

    @GetMapping("/downloadImagesAsZip")
    public ResponseEntity<Object> downloadImagesAsZip(@RequestParam("imagePaths") List<String> encodedImagePaths) throws IOException {

        List<String> decodedImagePaths = encodedImagePaths.stream()
                .map(this::decodeUrl)
                .collect(Collectors.toList());

        ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(zipOutputStream);

        for (String imageName : decodedImagePaths) {
            File imageFile = new File(imageName);
            if (imageFile.exists()) {
                FileInputStream fileInputStream = new FileInputStream(imageFile);
                ZipEntry zipEntry = new ZipEntry(imageFile.getName());
                zip.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    zip.write(buffer, 0, length);
                }

                fileInputStream.close();
                zip.closeEntry();
            }
        }

        zip.close();

        byte[] zipBytes = zipOutputStream.toByteArray();
        ByteArrayResource resource = new ByteArrayResource(zipBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=images.zip");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


    private String decodeUrl(String encodedPath) {
        try {
            return URLDecoder.decode(encodedPath, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // 处理解码异常
            return "";
        }
    }


//    @GetMapping("/downloadImagesAsZip2")
//    public ResponseEntity<Object> downloadImagesAsZip2(@RequestParam("imageNames") List<String> imageNamesJson) throws IOException {
//
////        List<String> imageNames = encodedImageNames.stream()
////                .map(this::decodeUrl)
////                .collect(Collectors.toList());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<String> imageNames = objectMapper.readValue((JsonParser) imageNamesJson, List.class);
//
//        ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
//        ZipOutputStream zip = new ZipOutputStream(zipOutputStream);
//
//        for (String imageName : imageNames) {
//            File imageFile = new File("D:/桌面文件/学习文件/秋招/照片/"+"微信图片_"+imageName+".jpg");
////            System.out.println(imageFile.getAbsolutePath());
////            System.out.println(imageFile.exists());
//            if (imageFile.exists()) {
//                FileInputStream fileInputStream = new FileInputStream(imageFile);
//                ZipEntry zipEntry = new ZipEntry(imageFile.getName());
//                zip.putNextEntry(zipEntry);
//
//                byte[] buffer = new byte[1024];
//                int length;
//                while ((length = fileInputStream.read(buffer)) > 0) {
//                    zip.write(buffer, 0, length);
//                }
//
//                fileInputStream.close();
//                zip.closeEntry();
//            }
//        }
//
//        zip.close();
//
//        byte[] zipBytes = zipOutputStream.toByteArray();
//        ByteArrayResource resource = new ByteArrayResource(zipBytes);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=images.zip");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }


    @PostMapping("/downloadImagesAsZip2")
    public ResponseEntity<Object> downloadImagesAsZip2(@RequestBody String jsonImageNames) throws IOException {
        Gson gson = new Gson();
        String[] imageNames = gson.fromJson(jsonImageNames, String[].class);

        ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(zipOutputStream);

        for (String imageName : imageNames) {
            File imageFile = new File("D:/桌面文件/学习文件/秋招/照片/" + "微信图片_" + imageName + ".jpg");
            if (imageFile.exists()) {
                FileInputStream fileInputStream = new FileInputStream(imageFile);
                ZipEntry zipEntry = new ZipEntry(imageFile.getName());
                zip.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    zip.write(buffer, 0, length);
                }

                fileInputStream.close();
                zip.closeEntry();
            }
        }

        zip.close();

        byte[] zipBytes = zipOutputStream.toByteArray();
        ByteArrayResource resource = new ByteArrayResource(zipBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=images.zip");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }



}
