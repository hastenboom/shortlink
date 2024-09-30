package com.hasten.shortlink.admin.controller;

import com.hasten.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hasten
 */
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
}
