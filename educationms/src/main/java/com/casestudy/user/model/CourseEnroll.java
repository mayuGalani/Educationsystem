package com.casestudy.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnroll {
    private UUID courseUuid;
    private UUID studentUuid;
}
