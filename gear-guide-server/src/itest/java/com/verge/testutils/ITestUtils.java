package com.verge.testutils;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.verge.dto.Dto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ITestUtils {

    private static Gson gson = new Gson();

    private static JsonParser parser = new JsonParser();

    public static RestTemplate getFormRestTemplate() {
        List<HttpMessageConverter<?>> converters = Lists.newArrayList(
                Lists.newArrayList(new MappingJackson2HttpMessageConverter(), new ResourceHttpMessageConverter())
        );

        return new RestTemplate(converters);
    }

    public static <T extends Dto> HttpEntity<MultiValueMap<String, Object>> createRequest(T details, File image) throws IOException {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();

        // creating an HttpEntity for the JSON part
        HttpHeaders jsonHeader = new HttpHeaders();
        jsonHeader.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JsonObject> detailsPart = new HttpEntity<>(convertDtoToJson(details), jsonHeader);

        // creating an HttpEntity for the binary part
        HttpHeaders pictureHeader = new HttpHeaders();
        pictureHeader.setContentType(MediaType.IMAGE_PNG);
        HttpEntity<ByteArrayResource> imagePart = new HttpEntity<>(getBytes(image), pictureHeader);

        // putting the two parts in one request
        multipartRequest.add("details", detailsPart);
        multipartRequest.add("image", imagePart);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multipartRequest, header);

        return requestEntity;
    }

    private static <T extends Dto> JsonObject convertDtoToJson(T dto) {
        String json = gson.toJson(dto);
        return parser.parse(json).getAsJsonObject();
    }

    private static ByteArrayResource getBytes(File file) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        byte[] bytes = Files.readAllBytes(path);
        return new ByteArrayResource(bytes);
    }

}
