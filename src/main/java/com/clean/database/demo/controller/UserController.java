package com.clean.database.demo.controller;

import com.clean.database.demo.entity.User;
import com.clean.database.demo.entity.ResponseMessage;
import com.clean.database.demo.exception.EmptyTableException;
import com.clean.database.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired(required = false)
    UserService userService;

    // start GET methods //
    @Operation(summary = "Get all User")
    @GetMapping(path="v1/user")
    public ResponseEntity<List<User>> getUser() {
        System.out.println("usesssssss");
        log.info("[user] v1/user is called");
        try {
            ResponseEntity<List<User>> response = new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
            log.info("[user] response length is: "+response.getBody().size());

            if (response.getBody().size() < 1) {
                throw new EmptyTableException("Data doesn't exist in table!!!");
            } else {
                return response;
            }
        } catch (InvalidDataAccessResourceUsageException e) { //db exists, tbl doesn't exist
            log.info("[user] exception message is: "+e);
            return new ResponseEntity<>(HttpStatus.GONE);
        } catch (CannotCreateTransactionException e) { //during springboot run, db is deleted
            log.info("[user] exception message is: "+e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        } catch (EmptyTableException e) { //tbl exists but is empty
            log.info("[user] exception message is: "+e);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) { //any other exceptions
            log.info("[FLO] exception message is: "+e);
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PostMapping(path="v1/user")
    public ResponseEntity<User> addUser(@RequestBody User addedUser) {
        try {
            return new ResponseEntity<>(userService.addUser(addedUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
