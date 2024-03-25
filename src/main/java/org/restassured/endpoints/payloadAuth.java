package org.restassured.endpoints;
import lombok.*;
@Data
public class payloadAuth {

    private String username;
    private String password;
    public payloadAuth(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
