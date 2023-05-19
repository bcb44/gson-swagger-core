package dev.bburnett.gsonswaggercore;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Custom AnnotationIntrospector to be passed into Jackson's ObjectMapper
 *
 * Source: <a href="https://bsideup.github.io/posts/custom_jackson_annotations/">...</a>
 */
public class GsonAnnotationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public String[] findEnumValues(Class<?> enumType, Enum<?>[] enumValues, String[] names) {
        Map<String, String> overrides = Stream.of(enumType.getDeclaredFields())
                .filter(it -> !it.isEnumConstant())
                .filter(it -> it.getAnnotation(SerializedName.class) != null)
                .collect(Collectors.toMap(
                        it -> it.getName(),
                        it -> it.getAnnotation(SerializedName.class).value()
                ));

        if (overrides.isEmpty()) {
            return super.findEnumValues(enumType, enumValues, names);
        }

        for (int i = 0; i < enumValues.length; ++i) {
            names[i] = overrides.getOrDefault(enumValues[i].name(), names[i]);
        }
        return names;
    }

    @Override
    public PropertyName findNameForSerialization(Annotated a) {
        SerializedName serializedName = a.getAnnotation(SerializedName.class);
        if (serializedName != null) {
            return PropertyName.construct(serializedName.value());
        }

        return super.findNameForSerialization(a);
    }

    @Override
    public PropertyName findNameForDeserialization(Annotated a) {
        SerializedName serializedName = a.getAnnotation(SerializedName.class);
        if (serializedName != null) {
            return PropertyName.construct(serializedName.value());
        }

        return super.findNameForDeserialization(a);
    }
}
