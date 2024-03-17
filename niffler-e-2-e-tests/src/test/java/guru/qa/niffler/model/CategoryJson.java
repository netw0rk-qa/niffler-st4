package guru.qa.niffler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryJson (
    @JsonProperty("category")
    String category,
    @JsonProperty("username")
    String username
){}
