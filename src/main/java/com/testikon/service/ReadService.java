package com.testikon.service;

import com.testikon.model.JsonPlaceHolderModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadService {

    public List<JsonPlaceHolderModel> getTitlesAndBodies(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);
        List<JsonPlaceHolderModel> posts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);
            for (JsonNode node : rootNode) {
                JsonPlaceHolderModel post = new JsonPlaceHolderModel();
                post.setTitle(node.get("title").asText());
                post.setBody(node.get("body").asText());
                posts.add(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public String getTitlesAndBodiesAsHtml(String url) {
        List<JsonPlaceHolderModel> posts = getTitlesAndBodies(url);
        StringBuilder htmlPosts = new StringBuilder();
        for (JsonPlaceHolderModel post : posts) {
            htmlPosts.append("<h1>").append(post.getTitle()).append("</h1><p>").append(post.getBody()).append("</p>");
        }
        return htmlPosts.toString();
    }
}
