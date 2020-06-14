package fabs.react.reducer.data;

import fabs.util.AbstractOptions;
import fabs.util.StringFormatter;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReducerCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "rcc.reducer";
    private final static String ACTION_TEMPLATE = "ACTION_TEMPLATE";
    private final static String ACTION_TYPES_TEMPLATE = "ACTION_TYPES_TEMPLATE";
    private final static String INDEX_TEMPLATE = "INDEX_TEMPLATE";
    private final static String TYPES_TEMPLATE = "TYPES_TEMPLATE";

    private String defaultActionTemplateFile = "templates/reducer/actions.ts.mustache";
    private String defaultModuleIndexTemplateFile = "templates/reducer/index.ts.mustache";
    private String defaultTypesTemplateFile = "templates/reducer/types.ts.mustache";
    private String defaultActionTypesTemplateFile = "templates/reducer/action-types.ts.mustache";

    private String actionTemplateFile = defaultActionTemplateFile;
    private String moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
    private String typesTemplateFile = defaultTypesTemplateFile;
    private String actionTypesTemplateFile = defaultActionTypesTemplateFile;

    private String actionFunctionName;
    private String moduleName;
    private String mutationType;


    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(ACTION_TEMPLATE, actionTemplateFile);
        element.setAttribute(INDEX_TEMPLATE, moduleIndexTemplateFile);
        element.setAttribute(ACTION_TYPES_TEMPLATE, actionTypesTemplateFile);
        element.setAttribute(TYPES_TEMPLATE, typesTemplateFile);
        return element;
    }

    public void deserialize(Element element) {
        setActionTemplateFile(element.getAttributeValue(ACTION_TEMPLATE));
        setActionTypesTemplateFile(element.getAttributeValue(ACTION_TYPES_TEMPLATE));
        setModuleIndexTemplateFile(element.getAttributeValue(INDEX_TEMPLATE));
        setTypesTemplateFile(element.getAttributeValue(TYPES_TEMPLATE));
    }

    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(actionTemplateFile);
        files.add(moduleIndexTemplateFile);
        files.add(typesTemplateFile);
        files.add(actionTypesTemplateFile);
        return files;
    }

    @Override
    public Map<String, String> getTemplateVariables() {
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

    public void setActionTemplateFile(String actionTemplateFile) {
        if (actionTemplateFile == null) {
            this.actionTemplateFile = null;
            return;
        }

        if (actionTemplateFile.isEmpty()) {
            this.actionTemplateFile = defaultActionTemplateFile;
            return;
        }
        this.actionTemplateFile = actionTemplateFile;
    }

    public void setModuleIndexTemplateFile(String moduleIndexTemplateFile) {
        if (moduleIndexTemplateFile == null) {
            this.moduleIndexTemplateFile = null;
            return;
        }

        if (moduleIndexTemplateFile.isEmpty()) {
            this.moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
            return;
        }
        this.moduleIndexTemplateFile = moduleIndexTemplateFile;
    }


    public void setTypesTemplateFile(String typesTemplateFile) {
        if (typesTemplateFile == null) {
            this.typesTemplateFile = null;
            return;
        }

        if (typesTemplateFile.isEmpty()) {
            this.typesTemplateFile = defaultTypesTemplateFile;
            return;
        }
        this.typesTemplateFile = typesTemplateFile;
    }

    public void setActionTypesTemplateFile(String actionTypesTemplateFile) {
        if (actionTypesTemplateFile == null) {
            this.actionTypesTemplateFile = null;
            return;
        }

        if (actionTypesTemplateFile.isEmpty()) {
            this.actionTypesTemplateFile = defaultActionTypesTemplateFile;
            return;
        }
        this.actionTypesTemplateFile = actionTypesTemplateFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReducerCreateOptions that = (ReducerCreateOptions) o;
        return Objects.equals(actionTemplateFile, that.actionTemplateFile) &&
                Objects.equals(moduleIndexTemplateFile, that.moduleIndexTemplateFile) &&
                Objects.equals(typesTemplateFile, that.typesTemplateFile) &&
                Objects.equals(actionTypesTemplateFile, that.actionTypesTemplateFile);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String getActionTemplateFile() {
        return actionTemplateFile;
    }

    public String getModuleIndexTemplateFile() {
        return moduleIndexTemplateFile;
    }

    public String getTypesTemplateFile() {
        return typesTemplateFile;
    }

    public String getActionTypesTemplateFile() {
        return actionTypesTemplateFile;
    }

    public boolean isActionTemplateDefault() {
        return this.actionTemplateFile.equals(this.defaultActionTemplateFile);
    }

    public boolean isModuleTemplateDefault() {
        return this.moduleIndexTemplateFile.equals(this.defaultModuleIndexTemplateFile);
    }

    public boolean isTypesTemplateDefault() {
        return this.typesTemplateFile.equals(this.defaultTypesTemplateFile);
    }

    public boolean isActionTypesTemplateDefault() {
        return this.actionTypesTemplateFile.equals(this.defaultActionTypesTemplateFile);
    }

    public void setActionFunctionName(String actionFunctionName) {
        this.actionFunctionName = actionFunctionName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setMutationType(String mutationType) {
        this.mutationType = mutationType;
    }
}
