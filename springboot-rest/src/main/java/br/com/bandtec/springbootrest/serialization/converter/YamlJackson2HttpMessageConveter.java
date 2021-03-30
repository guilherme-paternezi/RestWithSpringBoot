package br.com.bandtec.springbootrest.serialization.converter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public final class YamlJackson2HttpMessageConveter extends AbstractJackson2HttpMessageConverter {

    public YamlJackson2HttpMessageConveter() {
        super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
    }
}
