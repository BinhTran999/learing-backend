package com.vn.dev.core_be.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    SUCCESS("MS-000", "Success"),
    INVALID_PARAMETER("MS-001", "Invalid parameter"),
    NOT_FOUND("MS-002", "Entity Not Found"),
    EXTERNAL_SERVICE_SERVER_ERROR("MS-003", "External service error"),
    TOKEN_EXPIRED("MS-004", "Token expired"),
    FORBIDDEN("MS-005", "Forbidden"),
    UNAUTHORIZED("MS-006", "UNAUTHORIZED"),
    ERR_MAX_UPLOAD_SIZE("MS-007", "Max upload size file invalid"), CODE_EXISTED("MS-008", "Code existed"),
    EMAIL_INVALID("MS-009", "Email invalid"), PASSWORD_INVALID("MS-010", "Password invalid");

    private final String code;
    private final String detail;
}
