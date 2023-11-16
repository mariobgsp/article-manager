package com.example.articlemanager.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class AppProperties {

    private String secretKey = "M9NNje86aFRBWTK";
    private String auth = "a0s1SFRKbEtpbUwxZ3NQOg==";
    private String apiKey = "kK5HTJlKimL1gsP";

    private boolean enableAuth = true;
    private boolean enableApiKey = false;

}
