package testobjects;

import com.google.gson.annotations.SerializedName;

public class SimpleNameChanged {
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

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SimpleNameChanged)) {
            return false;
        }
        SimpleNameChanged otherNameChanged = (SimpleNameChanged) other;
        if (this.hello == null) {
            return otherNameChanged.getHello() == null;
        }
        return this.hello.equals(otherNameChanged.getHello());
    }


}
