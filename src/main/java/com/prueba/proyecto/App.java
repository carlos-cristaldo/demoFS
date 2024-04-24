package com.prueba.proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App 
{
    public static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.info("Hello World! ");
        logger.info("En SLF4J vienen definidos los siguientes niveles de log: ");
        logger.error("ERROR -> Cuando ocurrió un error.");
        logger.warn("WARN -> Circunstancia de posible error.");
        logger.info("INFO -> Información de la ejecución.");
        logger.debug("DEBUG -> Información importante a la hora de hacer debug.");
        logger.trace("TRACE -> Información de traza sobre la ejecución.");
        
        
        
        
    }
}
