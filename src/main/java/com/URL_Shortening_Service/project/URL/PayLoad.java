package com.URL_Shortening_Service.project.URL;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PayLoad {
    @NotBlank(message = "Field can't be empty")
    String url;
}
