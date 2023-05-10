package co.istad.mbanking.api.notification.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;

@Builder
public record NotificationDto(@JsonProperty("included_segments")
                              String[] includedSegments,
                              ContentDto contents,
                              @JsonProperty("app_id")
                              @Value("${onesignal.app-id}")
                              String appId) {
}
