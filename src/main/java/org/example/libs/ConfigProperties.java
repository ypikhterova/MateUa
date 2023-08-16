package org.example.libs;

import org.aeonbits.owner.Config;


@Config.Sources(value = "file:.\\src\\main\\resources\\config.properties")
public interface ConfigProperties extends Config {

    String BASE_URL();

    long TIME_FOR_DEFAULT_WAIT();

}
