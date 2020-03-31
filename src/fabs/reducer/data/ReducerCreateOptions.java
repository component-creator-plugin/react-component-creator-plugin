package fabs.reducer.data;

import java.util.ArrayList;

public class ReducerCreateOptions {
    private String actionTemplateFile = "templates/reducer/actions.ts.mustache";
    private String moduleIndexTemplateFile = "templates/reducer/index.ts.mustache";
    private String typesTemplateFile = "templates/reducer/types.ts.mustache";
    private String actionTypesTemplateFile = "templates/reducer/action-types.ts.mustache";

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
        this.actionTemplateFile = actionTemplateFile;
    }

    public String getModuleIndexTemplateFile() {
        return moduleIndexTemplateFile;
    }

    public void setModuleIndexTemplateFile(String moduleIndexTemplateFile) {
        this.moduleIndexTemplateFile = moduleIndexTemplateFile;
    }

    public String getTypesTemplateFile() {
        return typesTemplateFile;
    }

    public void setTypesTemplateFile(String typesTemplateFile) {
        this.typesTemplateFile = typesTemplateFile;
    }

    public String getActionTypesTemplateFile() {
        return actionTypesTemplateFile;
    }

    public void setActionTypesTemplateFile(String actionTypesTemplateFile) {
        this.actionTypesTemplateFile = actionTypesTemplateFile;
    }
}
