package es.pc.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BusinessException extends RuntimeException {
    private String codeId;

    public BusinessException(String message, String codeId) {
        super(message);
        this.codeId = codeId;
    }
}
