package com.beautyhub.beautyhubelk.domain;

import javax.validation.Payload;
import java.time.Instant;

public record LogEvent(String service, String event, Instant timestamp, Payload payload) {
}
