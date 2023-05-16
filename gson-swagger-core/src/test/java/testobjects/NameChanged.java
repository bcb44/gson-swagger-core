package testobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class NameChanged {
    public String getHello() {
        return hello;
    }


    public void setHello(String hello) {
        this.hello = hello;
    }


    // Equivalent of @Expose(deserialize=false) and @SerializedName("hello")
    // @JsonProperty(value = "hello", access = JsonProperty.Access.WRITE_ONLY)
    @SerializedName("gsonName")
    private String hello;
}
