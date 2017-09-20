package com.woowahan.blog.controller.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value="/v1/health-check")
    public HealthCheckResponse doCheck() {
        return HealthCheckResponse.ok();
    }


    @Getter @Setter
    public static class HealthCheckResponse {

        private boolean success;

        private HealthCheckResponse(boolean success) {
            this.success = success;
        }

        public static HealthCheckResponse ok() {
            return new HealthCheckResponse(true);
        }


    }
}
