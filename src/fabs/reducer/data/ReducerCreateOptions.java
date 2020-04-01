package fabs.reducer.data;

import java.util.ArrayList;

public class ReducerCreateOptions {
    private String defaultActionTemplateFile = "templates/reducer/actions.ts.mustache";
    private String defaultModuleIndexTemplateFile = "templates/reducer/index.ts.mustache";
    private String defaultTypesTemplateFile = "templates/reducer/types.ts.mustache";
    private String defaultActionTypesTemplateFile = "templates/reducer/action-types.ts.mustache";

    private String actionTemplateFile = defaultActionTemplateFile;
    private String moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
    private String typesTemplateFile = defaultTypesTemplateFile;
    private String actionTypesTemplateFile = defaultActionTypesTemplateFile;

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
