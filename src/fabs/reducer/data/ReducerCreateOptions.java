package fabs.reducer.data;

import fabs.reducer.state.ReducerSettingKeys;
import fabs.util.SerializableOptions;
import org.jdom.Element;

import java.util.ArrayList;

public class ReducerCreateOptions implements SerializableOptions {
    public static final String STORE_KEY = "ReducerSettings";

    private String defaultActionTemplateFile = "templates/reducer/actions.ts.mustache";
    private String defaultModuleIndexTemplateFile = "templates/reducer/index.ts.mustache";
    private String defaultTypesTemplateFile = "templates/reducer/types.ts.mustache";
    private String defaultActionTypesTemplateFile = "templates/reducer/action-types.ts.mustache";

    private String actionTemplateFile = defaultActionTemplateFile;
    private String moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
    private String typesTemplateFile = defaultTypesTemplateFile;
    private String actionTypesTemplateFile = defaultActionTypesTemplateFile;

    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(ReducerSettingKeys.ACTION_TEMPLATE, actionTemplateFile);
        element.setAttribute(ReducerSettingKeys.ACTION_TYPES_TEMPLATE, actionTypesTemplateFile);
        element.setAttribute(ReducerSettingKeys.INDEX_TEMPLATE, moduleIndexTemplateFile);
        element.setAttribute(ReducerSettingKeys.TYPES_TEMPLATE, typesTemplateFile);
        return element;
    }

    public void deserialize(Element element) {
        setActionTemplateFile(element.getAttributeValue(ReducerSettingKeys.ACTION_TEMPLATE));
        setActionTypesTemplateFile(element.getAttributeValue(ReducerSettingKeys.ACTION_TYPES_TEMPLATE));
        setModuleIndexTemplateFile(element.getAttributeValue(ReducerSettingKeys.INDEX_TEMPLATE));
        setTypesTemplateFile(element.getAttributeValue(ReducerSettingKeys.TYPES_TEMPLATE));
    }

    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();

        files.add(actionTemplateFile);
        files.add(moduleIndexTemplateFile);
        files.add(typesTemplateFile);
        files.add(actionTypesTemplateFile);

        return files;
    }

    public String getActionTemplateFile() {
        return actionTemplateFile;
    }

    public void setActionTemplateFile(String actionTemplateFile) {
        if (actionTemplateFile.isEmpty()) {
            this.actionTemplateFile = defaultActionTemplateFile;
            return;
        }
        this.actionTemplateFile = actionTemplateFile;
    }

    public String getModuleIndexTemplateFile() {
        return moduleIndexTemplateFile;
    }

    public void setModuleIndexTemplateFile(String moduleIndexTemplateFile) {
        if (moduleIndexTemplateFile.isEmpty()) {
            this.moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
            return;
        }
        this.moduleIndexTemplateFile = moduleIndexTemplateFile;
    }

    public String getTypesTemplateFile() {
        return typesTemplateFile;
    }

    public void setTypesTemplateFile(String typesTemplateFile) {
        if (typesTemplateFile.isEmpty()) {
            this.typesTemplateFile = defaultTypesTemplateFile;
            return;
        }
        this.typesTemplateFile = typesTemplateFile;
    }

    public String getActionTypesTemplateFile() {
        return actionTypesTemplateFile;
    }

    public void setActionTypesTemplateFile(String actionTypesTemplateFile) {
        if (actionTypesTemplateFile.isEmpty()) {
            this.actionTypesTemplateFile = defaultActionTypesTemplateFile;
            return;
        }
        this.actionTypesTemplateFile = actionTypesTemplateFile;
    }
}
