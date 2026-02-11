package com.hospitalManagementSystem.module35.dto;

import com.hospitalManagementSystem.module35.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
