package org.example.exception

import org.example.model.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandling {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception) : ResponseEntity<ErrorMessageModel> {
        val errorBody = ErrorMessageModel(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            title = "Generic unknown error",
            detail = ex.message!!
        )

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorBody)
    }
}