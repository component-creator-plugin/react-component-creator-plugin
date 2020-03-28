package fabs.component;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.samskivert.mustache.Template;
import fabs.util.AbstractCreator;
import fabs.util.FileUtils;
import fabs.util.StringFormatter;
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

        templateModel.put("componentCamelcaseName", StringFormatter.toCamelCase(componentName));

        for (int i = 0; i < filesToInclude.length; i++) {
            String file = filesToInclude[i];
            utils.writeFile(
                TemplateRenderer.render(file, templateModel),
                componentDirectory.createChildData(componentDirectory, TemplateRenderer.transformTemplateName(file, componentName)
            ));
        }
    }
}
