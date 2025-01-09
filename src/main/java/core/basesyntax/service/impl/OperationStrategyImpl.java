package core.basesyntax.service.impl;

import core.basesyntax.exceptions.OperationDefinitionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> transactionMap) {
        this.operationMap = transactionMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler operationHandler;
        if ((operationHandler = operationMap.get(operation)) == null) {
            throw new OperationDefinitionException();
        }
        return operationHandler;
    }
}
