package gsonswaggerplugin

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration
import io.swagger.v3.oas.integration.api.OpenApiReader
import io.swagger.v3.oas.models.OpenAPI

class GsonReader : OpenApiReader {
    override fun setConfiguration(openApiConfiguration: OpenAPIConfiguration?) {
        TODO("Not yet implemented")
    }

    override fun read(classes: MutableSet<Class<*>>?, resources: MutableMap<String, Any>?): OpenAPI {
        TODO("Not yet implemented")
    }

    private fun createCustomObjectMapper() : ObjectMapper {
        val mapper = JsonMapper.builder()
            .configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true)
            .build()
        mapper.setAnnotationIntrospector(GsonAnnotationIntrospector())
        return mapper;
    }
}