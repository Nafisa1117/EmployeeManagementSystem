package com.masai.exception;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetails {

	@NotBlank(message = "Time must not be null")
	@NotNull(message = "Time must not be null")
	private LocalDateTime timestamp;
	
	@NotNull(message = "Message must not be null...")
	private String message;
	
	@NotNull(message = "Details must not be null...")
	private String details;
}
