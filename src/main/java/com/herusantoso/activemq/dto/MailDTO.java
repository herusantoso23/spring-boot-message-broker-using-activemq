package com.herusantoso.activemq.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class MailDTO implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    @NotBlank
    private String to;

    @NotBlank
    private String message;

}
