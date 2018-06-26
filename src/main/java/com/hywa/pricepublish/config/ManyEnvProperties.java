package com.hywa.pricepublish.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ManyEnvProperties {

    @Value("${GD.key}")
    private String Gd_Key;

    @Value("${File.path}")
    private String FILE_PATH;
}
