package fabs.component;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.FileUtils;
import fabs.util.TemplateRenderer;

import java.io.IOException;
import java.util.Map;

public class ComponentCreator extends AbstractCreator {
    protected VirtualFile directory;
    protected String componentName;
    protected String[] filesToInclude;
    protected Map<String, Object> templateModel;


    public ComponentCreator(VirtualFile directory, String componentName, Map<String, Object> templateModel, String[] files) {
        this.directory = directory;
        this.componentName = componentName;
        this.templateModel = templateModel;
        this.filesToInclude = files;
    }

    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        VirtualFile componentDirectory = directory.createChildDirectory(directory, componentName);

        FileUtils utils = new FileUtils();
        TemplateRenderer renderer = new TemplateRenderer();

        templateModel.put("componentCamelcaseName", toCamelCase(componentName));

        for (int i = 0; i < filesToInclude.length; i++) {
            String file = filesToInclude[i];
            utils.writeFile(renderer.render(file, templateModel), componentDirectory.createChildData(componentDirectory, transformTemplateName(file, componentName)));
        }
    }

    private String toCamelCase(String input) {
        StringBuffer sb = new StringBuffer();
        for (String s : input.split("-")) {
            sb.append(Character.toUpperCase(s.charAt(0)));
            if (s.length() > 1) {
                sb.append(s.substring(1, s.length()).toLowerCase());
            }
        }
        return sb.toString();

    }

    private String transformTemplateName(String templateString, String componentName) {
        String[] parts = templateString.split("/");
        String fileName = parts[parts.length - 1];
        return fileName
                .replace(".mustache", "")
                .replace("component", componentName)
                ;
    }


}
