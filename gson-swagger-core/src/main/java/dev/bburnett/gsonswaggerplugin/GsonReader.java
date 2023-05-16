package dev.bburnett.gsonswaggerplugin;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.jaxrs2.Reader;
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration;
import io.swagger.v3.oas.models.OpenAPI;

public class GsonReader extends Reader {
    public GsonReader() {
        super();
        configureGsonMapping();
    }

    public GsonReader(OpenAPIConfiguration openApiConfiguration) {
        super(openApiConfiguration);
        configureGsonMapping();
    }

    public GsonReader(OpenAPI openApi) {
        super(openApi);
        configureGsonMapping();
    }

    private void configureGsonMapping() {
        ModelConverters converters = ModelConverters.getInstance();
        ObjectMapper om = JsonMapper.builder()
                .configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true)
                .annotationIntrospector(new GsonAnnotationIntrospector())
                .build();
        ModelResolver resolver = new ModelResolver(om);
        converters.addConverter(resolver);
    }
}
