package nl.novi.risk.service;

import nl.novi.risk.domain.Computer;
import org.springframework.beans.factory.annotation.Autowired;

public class ComputerNotFoundException extends Computer {
    private Object IMessageResolver;

    public ComputerNotFoundException(String s) {
    }

    public Object ComputerNotFoundException(String s, Object iMessageResolver) {
        IMessageResolver = iMessageResolver;
        return IMessageResolver;
    }
}
