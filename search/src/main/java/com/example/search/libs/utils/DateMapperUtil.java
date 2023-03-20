package com.example.search.libs.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateMapperUtil {
  public static LocalDateTime instantToLocalDateTime(Instant instant) {
    return instant
        .atZone(getZoneId())
        .toLocalDateTime();
  }

  public static Instant localDateTimeToInstant(LocalDateTime localDateTime) {
    return localDateTime.toInstant(getZoneOffset());
  }

  public static Long localDateTimeToLong(LocalDateTime localDateTime) {
    return localDateTimeToInstant(localDateTime).toEpochMilli();
  }

  public static LocalDateTime longToLocalDateTime(Long longTime) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(longTime), getZoneOffset());
  }

  public static ZoneOffset getZoneOffset() {
    return getZoneId().getRules().getOffset(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
  }

  public static ZoneId getZoneId() {
    return ZoneId.of("Asia/Seoul");
  }

}
