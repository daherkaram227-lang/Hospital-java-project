package org.example;

import java.time.LocalDateTime;

enum Operationtype{
    Orthopedicsurgery,
    Neurosurgery,
    Cardiacsurgery

}

public class Operation extends Appointment {

    private Operationtype type;
    public Operation(String OperationStart, String OperationEnd, Status status, boolean isOperation,Operationtype type) {
        super(OperationStart, OperationEnd, status,isOperation);
    this.type=type;
    }

    @Override
    public String Treat() {
        return "";
    }
}
