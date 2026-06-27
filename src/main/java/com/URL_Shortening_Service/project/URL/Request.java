package com.URL_Shortening_Service.project.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Request {
    @NotBlank(message = "can't leave empty")
    String shortcode;
}
