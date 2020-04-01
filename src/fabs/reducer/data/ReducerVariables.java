package fabs.reducer.data;

import fabs.util.StringFormatter;
import fabs.util.VariableHolder;

import java.util.HashMap;
import java.util.Map;

public class ReducerVariables implements VariableHolder {
    private String actionFunctionName;
    private String moduleName;
    private String mutationType;

    public ReducerVariables(String actionFunctionName, String moduleName, String mutationType) {
        this.actionFunctionName = actionFunctionName;
        this.moduleName = moduleName;
        this.mutationType = mutationType;
    }

    public Map<String, String> toMap() {
        Map<String, String> templateModel = new HashMap<>();

        templateModel.put("actionFunctionName", actionFunctionName);
        templateModel.put("moduleName", moduleName);
        templateModel.put("mutationType", mutationType);

        templateModel.put("moduleNamePascalCase", StringFormatter.toCamelCase(moduleName));
        templateModel.put("stateName", StringFormatter.toCamelCase(moduleName) + "State");
        templateModel.put("actionTypeName", StringFormatter.capitalizeFirst(actionFunctionName) + "Action");
        templateModel.put("actionTypesEnumName", StringFormatter.toDashCase(moduleName).toUpperCase() + "_ACTIONS");

        return templateModel;
    }
}
