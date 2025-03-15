package com.tienda;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
/*
@Configuration se llama una notacion depiendo de archivo de java hay que definirle la  notacion que esto indica que tipos
de clases o que tipo de metodos en la clase java , osea @Configuration es un archivo de configuracion
*/
@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    /* Los siguientes métodos son para incorporar el tema de internacionalización en el proyecto */
    
    /* localeResolver se utiliza para crear una sesión de cambio de idioma*/
    @Bean
    /*
    public LocaleResolver localeResolver : se va encargar al gestionar el idioma y la region del usuario
    slr : crea una nueva SessionLocaleResolver
    slr.setDefaultLocale : hagarre localmente el idioma prederterminado
      slr.setLocaleAttributeName : va definir el nombre del atributo de la sesion que contiene el idioma actual (cambio 
    de idioma manualmente)
     slr.setTimeZoneAttributeName : va obtener el timezone de la persona
    */
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    /* localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma*/
    /*
    LocaleChangeInterceptor : es un interceptor ( intercepta la peticion que la persona hace para cambiar el idioma)
    var es la variable
     lci.setParamName("lang") : es un parametro que va recibir la url que va tener la  peticion
    ( si lang incluye es va modificarlo a español o si lang inclute en va cambiar el ingles
    */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    /*
     public void addInterceptors : se utiliza para registrar el cambio de idioma de la configuracion spring
    */
    
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    //Bean para poder acceder a los Messages.properties en código...
    /*
    Encoding : sea la traduccion correctamente que no haya un error del idioma
    messageSource: carga todos los archivos que tenemos en la parte de los messages
    nota: todo lo que estamos haciendo es por medio de una librerias
    */
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}