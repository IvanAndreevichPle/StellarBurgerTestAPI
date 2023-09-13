package api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:BaseConfig.properties"})
public interface BaseConfig extends Config {
    @Config.Key("BASE_URL")
    String baseURL();

    @Config.Key("ORDER_URL")
    String orderURL();

    @Config.Key("AUTH_USER")
    String authUSER();
}
