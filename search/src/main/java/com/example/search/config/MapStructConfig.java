package com.example.search.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface MapStructConfig {

}
