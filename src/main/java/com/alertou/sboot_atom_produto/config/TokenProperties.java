package com.alertou.sboot_atom_produto.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security.token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenProperties {
    private String secret;
}
