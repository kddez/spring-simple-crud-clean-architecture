package tech.kddez.user.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RestErrorMessage {
    private String message;
    private HttpStatus status;
}
