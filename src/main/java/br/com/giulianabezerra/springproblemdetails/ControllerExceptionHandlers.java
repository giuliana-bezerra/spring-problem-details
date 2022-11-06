package br.com.giulianabezerra.springproblemdetails;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandlers {

  @ExceptionHandler(ConflictException.class)
  private ResponseEntity<Object> handleConflictException(ConflictException exception) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    exception.printStackTrace(pw);

    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
        HttpStatus.valueOf(409), sw.toString());
    problemDetail.setTitle(exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(problemDetail);
  }
}
