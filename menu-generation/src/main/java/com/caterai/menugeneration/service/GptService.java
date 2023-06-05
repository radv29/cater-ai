package com.caterai.menugeneration.service;

import com.caterai.menugeneration.dto.GptRequestDTO;
import com.caterai.menugeneration.dto.GptResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class GptService {


    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.max_tokens}")
    private int maxTokens;

    public String chat(@RequestParam String prompt) {
        GptRequestDTO request = new GptRequestDTO(model, prompt, maxTokens);

        GptResponseDTO response = restTemplate.postForObject(apiUrl, request, GptResponseDTO.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        return response.getChoices().get(0).getText();

    }
}
