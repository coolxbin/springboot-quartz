package org.mallen.test.quartz.boot.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mallen
 * @date 4/18/19
 */
@RestController
public class SimpleController {
    @Autowired
    private SimpleRepository simpleRepo;

    @GetMapping("getName")
    public String getName() {
        final String[] name = {"data is not exist"};
        simpleRepo.findById("1").ifPresent(u -> name[0] = u.getName());
        return name[0];
    }
}
