package com.muchinfo.wallet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConfigurationProperties(prefix = "wallet")
@Data
@Primary
public class WalletConfig {

    private String address;

    private String name;

    private String password;

}
