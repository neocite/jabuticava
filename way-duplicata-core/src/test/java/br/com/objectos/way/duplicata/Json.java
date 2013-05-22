/*
 * Json.java criado em 20/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.ser.std.ScalarSerializerBase;
import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.br.Cep;
import br.com.objectos.comuns.base.br.Cnpj;
import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

import com.google.common.base.Throwables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class Json {

  static final ObjectMapper mapper = new ObjectMapper();

  static {
    mapper.configure(org.codehaus.jackson.map.SerializationConfig.Feature.INDENT_OUTPUT, true);
    mapper.registerModule(new PrivateModule());

    VisibilityChecker<?> checker = mapper.getVisibilityChecker();
    mapper.setVisibilityChecker(
        checker
            .withFieldVisibility(JsonAutoDetect.Visibility.NONE)
            .withGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY)
            .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
        );
  }

  public static String toString(Object ctx) {
    try {
      return mapper.writeValueAsString(ctx);
    } catch (JsonGenerationException e) {
      throw Throwables.propagate(e);
    } catch (JsonMappingException e) {
      throw Throwables.propagate(e);
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

  private static class PrivateModule extends SimpleModule {
    public PrivateModule() {
      super("JsonModule", new Version(3, 0, 0, "GA"));
      addSerializer(Cep.class, new CepSerializer());
      addSerializer(Cnpj.class, new CnpjSerializer());
      addSerializer(LocalDate.class, new LocalDateSerializer());
      addSerializer(ValorFinanceiro.class, new ValorFinanceiroSerializer());
    }
  }

  private static class CepSerializer extends ScalarSerializerBase<Cep> {
    public CepSerializer() {
      super(Cep.class);
    }

    @Override
    public void serialize(Cep value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException {
      jgen.writeString(value.toString());
    }
  }

  private static class CnpjSerializer extends ScalarSerializerBase<Cnpj> {
    public CnpjSerializer() {
      super(Cnpj.class);
    }

    @Override
    public void serialize(Cnpj value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException {
      jgen.writeString(value.toString());
    }
  }

  private static class LocalDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {

      jgen.writeStartObject();
      jgen.writeObjectField("iso", value.toString());
      jgen.writeObjectField("dd_mm_yyyy", value.toString("dd/MM/yyyy"));
      jgen.writeObjectField("dd_mm_yy", value.toString("dd/MM/yy"));
      jgen.writeEndObject();

    }
  }

  private static class ValorFinanceiroSerializer extends JsonSerializer<ValorFinanceiro> {
    @Override
    public void serialize(ValorFinanceiro value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {

      double doubleValue = value.doubleValue();
      String text = value.toString();

      jgen.writeStartObject();
      jgen.writeBooleanField("zero", value.isZero());
      jgen.writeObjectField("doubleValue", doubleValue);
      jgen.writeObjectField("text", text);
      jgen.writeEndObject();

    }
  }

}