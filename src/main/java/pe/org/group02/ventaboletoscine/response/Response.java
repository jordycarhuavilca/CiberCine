package pe.org.group02.ventaboletoscine.response;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record Response<T> (HttpStatus http, @Nullable T body, @Nullable String error){}
