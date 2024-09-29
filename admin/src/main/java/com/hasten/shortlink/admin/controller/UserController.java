package com.hasten.shortlink.admin.controller;

import com.hasten.shortlink.admin.common.convention.result.Result;
import com.hasten.shortlink.admin.common.convention.result.Results;
import com.hasten.shortlink.admin.dto.resp.UserRespDTO;
import com.hasten.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hasten
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 查询到的是脱敏后的用户信息
     * @param username
     * @return
     */
   @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        UserRespDTO result = userService.getUserByUsername(username);
        return Results.success(result);
    }
}
