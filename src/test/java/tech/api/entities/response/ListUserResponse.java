package tech.api.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUserResponse {

    String data;
    String id;
    String email;
    String first_name;
    String last_name;
    String avatar;
    String support;
    String url;
    String text;

}
