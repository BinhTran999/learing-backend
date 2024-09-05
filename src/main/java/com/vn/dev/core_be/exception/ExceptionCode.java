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
    USER_EXISTED("MS-011", "Nhân viên đã tồn tại. Vui lòng nhập lại"),
    TOKEN_EXPIRED("MS-004", "Token expired"),
    FORBIDDEN("MS-005", "Forbidden"),
    UNAUTHORIZED("MS-006", "UNAUTHORIZED"),
    INVALID_PHONE("MS-012", "Định dạng số điện thoại không đúng. Vui lòng nhập lại"),
    INVALID_MAIL("MS-013", "Định dạng mail không đúng. Vui lòng nhập lại"),
    INVALID_NAME("MS-014", "Name rỗng hoặc vượt quá 255 kí tự. Vui lòng nhập lại"),
    EXISTS_MAIL("MS-015", "Mail đã tồn tại. Vui lòng nhập lại"),
    INVALID_BIRTH("MS-016", "Ngày sinh không đúng định dạng: Phải nhỏ hơn ngày hiện tại"),
    ERR_MAX_UPLOAD_SIZE("MS-007", "Max upload size file invalid"), CODE_EXISTED("MS-008", "Code existed"),
    EMAIL_INVALID("MS-009", "Email invalid"), PASSWORD_INVALID("MS-010", "Password invalid");
    private final String code;
    private final String detail;
}
