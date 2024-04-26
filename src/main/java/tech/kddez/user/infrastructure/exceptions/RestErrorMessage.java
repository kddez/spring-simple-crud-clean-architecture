package tech.kddez.user.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RestErrorMessage {

    private String message;
    private HttpStatus status;

}
