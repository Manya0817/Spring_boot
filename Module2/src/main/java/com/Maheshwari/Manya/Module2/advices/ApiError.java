package com.Maheshwari.Manya.Module2.advices;

import jdk.dynalink.linker.LinkerServices;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.cert.CertPathBuilder;
import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
