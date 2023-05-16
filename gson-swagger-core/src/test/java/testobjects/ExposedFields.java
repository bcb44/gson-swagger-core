package testobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExposedFields {
    private transient String transientField;

    @Expose(deserialize = false)
    private String serializeOnly;

    @Expose(serialize = false)
    private String deserializeOnly;

    @Expose()
    private String both;

    @Expose()
    @SerializedName("hello")
    private String diff;

    private String setterOnly = "2";

    private String getterOnly = "1";

    public ExposedFields(String transientField, String serializeOnly, String deserializeOnly, String both) {
        this.transientField = transientField;
        this.serializeOnly = serializeOnly;
        this.deserializeOnly = deserializeOnly;
        this.both = both;
        this.diff = "hello";
    }

    public ExposedFields() {

    }


    public String getTransientField() {
        return transientField;
    }

    public void setTransientField(String transientField) {
        this.transientField = transientField;
    }

    public String getDeserializeOnly() {
        return deserializeOnly;
    }

    public void setDeserializeOnly(String deserializeOnly) {
        this.deserializeOnly = deserializeOnly;
    }

    public String getSerializeOnly() {
        return serializeOnly;
    }

    public void setSerializeOnly(String serializeOnly) {
        this.serializeOnly = serializeOnly;
    }

    public String getBoth() {
        return both;
    }

    public void setBoth(String both) {
        this.both = both;
    }

    public String getDiffName() {
        return diff;
    }

    public void setDiffName(String diff) {
        this.diff = diff;
    }

    public void setSetterOnly(String setterOnly) {
        this.setterOnly = setterOnly;
    }

    public String getGetterOnly() {
        return getterOnly;
    }
}
