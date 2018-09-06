package com.lamaknyo.api.common.exceptions;

import com.lamaknyo.api.common.restemplate.Res;
import com.lamaknyo.api.common.restemplate.ResError;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler {

    private static HttpStatus statusResponseDefault = HttpStatus.OK;
    private HttpStatus status;
    private HttpHeaders headers;

    /*Copy dari extends ResponseEntityExceptionHandler*/
    @ExceptionHandler({
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            MissingServletRequestPartException.class,
            BindException.class,
            NoHandlerFoundException.class,
            AsyncRequestTimeoutException.class
    })
    public final ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        headers = new HttpHeaders();
        System.out.print("\nEX +> " + ex + " ");

        if (ex instanceof HttpRequestMethodNotSupportedException) {
            status = HttpStatus.METHOD_NOT_ALLOWED;
        } else if (ex instanceof HttpMediaTypeNotSupportedException) {
            status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        } else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            status = HttpStatus.NOT_ACCEPTABLE;
        } else if (ex instanceof MissingPathVariableException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (ex instanceof MissingServletRequestParameterException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof ServletRequestBindingException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof ConversionNotSupportedException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (ex instanceof TypeMismatchException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof HttpMessageNotReadableException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof HttpMessageNotWritableException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (ex instanceof MethodArgumentNotValidException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof MissingServletRequestPartException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof BindException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof NoHandlerFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof AsyncRequestTimeoutException) {
            status = HttpStatus.SERVICE_UNAVAILABLE;
        } else {
            return generate("Unknown Error", -1);
        }

        return generate(status.getReasonPhrase(), status.value());
    }


    @ExceptionHandler(NoResultException.class)
    public final ResponseEntity<Object> handleNoResult(NoResultException ex, WebRequest request) {
        System.out.print("\nEX +> " + ex + " ");
        return generate(ex.getMessage(), HttpStatus.NO_CONTENT.value());
    }

    @ExceptionHandler(AuthException.class)
    public final ResponseEntity<Object> handleAuth(AuthException ex, WebRequest request) {
        System.out.print("\nEX +> " + ex + " ");
        return generate(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }

    private ResponseEntity<Object> generate(String message, int code) {
        ResError e = new ResError();
        e.setMessage(message);
        e.setCode(code);

        Res res = new Res();
        res.setSuccess(false);
        res.setError(e);

        return new ResponseEntity<>(res, statusResponseDefault);
    }

}


