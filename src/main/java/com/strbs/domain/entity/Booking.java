package com.strbs.domain.entity;

import com.strbs.domain.BaseModel;
import com.strbs.domain.BaseTimestampedModel;
import lombok.Getter;

@Getter
public class Booking extends BaseTimestampedModel implements BaseModel {

    private Long id;
}
