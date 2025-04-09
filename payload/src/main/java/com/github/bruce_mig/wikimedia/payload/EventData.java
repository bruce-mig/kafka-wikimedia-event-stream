package com.github.bruce_mig.wikimedia.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventData {

    @JsonProperty("$schema")
    private String schema;
    private EventMeta meta;
    private Integer id;
    private String type;
    private Integer namespace;
    private String title;
    @JsonProperty("title_url")
    private String titleUrl;
    private String comment;
    private Integer timestamp;
    private String user;
    private Boolean bot;
    @JsonProperty("notify_url")
    private String notifyUrl;
    private Boolean minor;
    private Boolean patrolled;
    private Length length;
    private Revision revision;
    @JsonProperty("server_url")
    private String serverUrl;
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("server_script_path")
    private String serverScriptPath;
    private String wiki;
    @JsonProperty("parsedcomment")
    private String parsedComment;
}
