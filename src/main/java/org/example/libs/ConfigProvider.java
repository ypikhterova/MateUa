package org.example.libs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
}
