package pl.klugeradoslaw.ex04readstackcrud.domain.api;

import java.time.LocalDateTime;

public class DiscoveryBasicInfoDto {
    private String title;
    private String url;
    private String description;
    private LocalDateTime dateAdded;

    public DiscoveryBasicInfoDto(String title, String url, String description, LocalDateTime dateAdded) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
}
