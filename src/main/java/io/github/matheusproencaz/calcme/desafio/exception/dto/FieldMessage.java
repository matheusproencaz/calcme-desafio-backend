package io.github.matheusproencaz.calcme.desafio.exception.dto;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = -13312869797623961L;

    private String fieldName;
    private String message;

    public FieldMessage() {
    }
    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
