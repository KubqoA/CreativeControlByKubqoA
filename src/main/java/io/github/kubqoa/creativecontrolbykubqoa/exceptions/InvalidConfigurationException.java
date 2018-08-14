package io.github.kubqoa.creativecontrolbykubqoa.exceptions;

public class InvalidConfigurationException extends Exception {
    public InvalidConfigurationException(String configurationOption) {
        super("Invalid configuration option for " + configurationOption);
    }
}
