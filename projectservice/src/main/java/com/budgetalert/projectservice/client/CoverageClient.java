package com.budgetalert.projectservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "coverage-service")
    public interface CoverageClient {

        @PostMapping("/coverage/calculate/{projectId}")
        void calculateCoverage(@PathVariable Long projectId);
    }


