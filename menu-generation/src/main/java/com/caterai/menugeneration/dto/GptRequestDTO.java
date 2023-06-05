package com.caterai.menugeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GptRequestDTO {

    private String model;
    private String prompt;
    private int max_tokens;

}
