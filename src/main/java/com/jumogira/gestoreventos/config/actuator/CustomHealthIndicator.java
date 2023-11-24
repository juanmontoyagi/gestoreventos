package com.jumogira.gestoreventos.config.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(org.springframework.boot.actuate.health.Health.Builder builder) throws Exception {
        builder.up()
                .withDetail("API OK", "API OK");
    }
}
