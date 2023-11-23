package com.casestudy.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EducationService.class})
@ExtendWith(SpringExtension.class)
class EducationServiceTest {
    @Autowired
    private EducationService educationService;

    /**
     * Method under test: {@link EducationService#helloString(String)}
     */
    @Test
    void testHelloString() {
        assertEquals("Hello janedoe", educationService.helloString("janedoe"));
    }
}

