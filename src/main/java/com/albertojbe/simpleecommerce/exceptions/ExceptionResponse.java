package com.albertojbe.simpleecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
     @Serial
     private static final long serialVersionUID = 1L;

     private String message;
     private LocalDateTime timestamp;
     private String details;
}
