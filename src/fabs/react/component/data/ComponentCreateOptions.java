package fabs.react.component.data;

import fabs.util.AbstractOptions;
import fabs.util.StringFormatter;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "rcc.component";
    private final String COMPONENT_TEMPLATE_KEY = "COMPONENT_TEMPLATE_KEY";
    private final String SASS_TEMPLATE_KEY = "SASS_TEMPLATE_KEY";
    private final String SPEC_TEMPLATE_KEY = "SPEC_TEMPLATE_KEY";
    private final String STORY_TEMPLATE_KEY = "STORY_TEMPLATE_KEY";
    private final String MD_TEMPLATE_KEY = "MD_TEMPLATE_KEY";

    private final String defaultComponentTemplateFile = "templates/component/{{componentName}}.tsx.mustache";
    private final String defaultSassTemplateFile = "templates/component/_{{componentName}}.scss.mustache";
    private final String defaultSpecTemplateFile = "templates/component/{{componentName}}.spec.tsx.mustache";
    private final String defaultStoryTemplateFile = "templates/component/{{componentName}}.story.tsx.mustache";
    private final String defaultMarkdownTemplateFile = "templates/component/{{componentName}}.md.mustache";

    private String componentTemplateFile = defaultComponentTemplateFile;
    private String sassTemplateFile = defaultSassTemplateFile;
    private String specTemplateFile = defaultSpecTemplateFile;
    private String storyTemplateFile = defaultStoryTemplateFile;
    private String markdownTemplateFile = defaultMarkdownTemplateFile;

    private final String MD_CHECKBOX_KEY = "MD_CHECKBOX_KEY";
    private final String STORY_CHECKBOX_KEY = "STORY_CHECKBOX_KEY";
    private final String SCSS_CHECKBOX_KEY = "SCSS_CHECKBOX_KEY";
    private final String SPEC_CHECKBOX_KEY = "SPEC_CHECKBOX_KEY";

    private boolean isCreateStorybookDefaultChecked = false;
    private boolean isCreateSpecDefaultChecked = false;
    private boolean isCreateScssDefaultChecked = false;
    private boolean isCreateMarkdownDefaultChecked = false;

    private Boolean isCreateSassFile = false;
    private Boolean isCreateSpecFile = false;
    private Boolean isCreateStoryFile = false;
    private Boolean isCreateMDFile = false;

    private String componentName;

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(COMPONENT_TEMPLATE_KEY, componentTemplateFile);
        element.setAttribute(SASS_TEMPLATE_KEY, sassTemplateFile);
        element.setAttribute(SPEC_TEMPLATE_KEY, specTemplateFile);
        element.setAttribute(STORY_TEMPLATE_KEY, storyTemplateFile);
        element.setAttribute(MD_TEMPLATE_KEY, markdownTemplateFile);

        element.setAttribute(MD_CHECKBOX_KEY, Boolean.toString(isCreateMarkdownDefaultChecked));
        element.setAttribute(STORY_CHECKBOX_KEY, Boolean.toString(isCreateStorybookDefaultChecked));
        element.setAttribute(SCSS_CHECKBOX_KEY, Boolean.toString(isCreateScssDefaultChecked));
        element.setAttribute(SPEC_CHECKBOX_KEY, Boolean.toString(isCreateSpecDefaultChecked));
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setSassTemplateFile(element.getAttributeValue(SASS_TEMPLATE_KEY));
        setSpecTemplateFile(element.getAttributeValue(SPEC_TEMPLATE_KEY));
        setStoryTemplateFile(element.getAttributeValue(STORY_TEMPLATE_KEY));
        setMarkdownTemplateFile(element.getAttributeValue(MD_TEMPLATE_KEY));

        setCreateMarkdownDefaultChecked(Boolean.valueOf(element.getAttributeValue(MD_TEMPLATE_KEY)));
        setCreateStorybookDefaultChecked(Boolean.valueOf(element.getAttributeValue(STORY_CHECKBOX_KEY)));
        setCreateScssDefaultChecked(Boolean.valueOf(element.getAttributeValue(SCSS_CHECKBOX_KEY)));
        setCreateSpecDefaultChecked(Boolean.valueOf(element.getAttributeValue(SPEC_CHECKBOX_KEY)));
    }

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(componentTemplateFile);

        if (isCreateStoryFile) {
            files.add(storyTemplateFile);
        }

        if (isCreateSassFile) {
            files.add(sassTemplateFile);
        }

        if (isCreateSpecFile) {
            files.add(specTemplateFile);
        }

        if (isCreateMDFile) {
            files.add(this.markdownTemplateFile);
        }
        return files;
    }

    @Override
    public Map<String, String> getTemplateVariables() {
        Map<String, String> templateModel = new HashMap<>();

        templateModel.put("componentName", componentName);
        templateModel.put("componentCamelcaseName", StringFormatter.toCamelCase(componentName));

        return templateModel;
    }

    public void setComponentTemplateFile(String componentTemplateFile) {
        if (componentTemplateFile == null || componentTemplateFile.isEmpty()) {
            this.componentTemplateFile = defaultComponentTemplateFile;
            return;
        }
        this.componentTemplateFile = componentTemplateFile;
    }


    public void setSassTemplateFile(String sassTemplateFile) {
        if (sassTemplateFile == null || sassTemplateFile.isEmpty()) {
            this.sassTemplateFile = defaultSassTemplateFile;
            return;
        }
        this.sassTemplateFile = sassTemplateFile;
    }


    public void setSpecTemplateFile(String specTemplateFile) {
        if (specTemplateFile == null || specTemplateFile.isEmpty()) {
            this.specTemplateFile = defaultSpecTemplateFile;
            return;
        }
        this.specTemplateFile = specTemplateFile;
    }


    public void setStoryTemplateFile(String storyTemplateFile) {
        if (storyTemplateFile == null || storyTemplateFile.isEmpty()) {
            this.storyTemplateFile = defaultStoryTemplateFile;
            return;
        }
        this.storyTemplateFile = storyTemplateFile;
    }


    public void setMarkdownTemplateFile(String markdownTemplateFile) {
        if (markdownTemplateFile == null || markdownTemplateFile.isEmpty()) {
            this.markdownTemplateFile = defaultMarkdownTemplateFile;
            return;
        }
        this.markdownTemplateFile = markdownTemplateFile;
    }

    public boolean isComponentTemplateDefault() {
        return componentTemplateFile.equals(defaultComponentTemplateFile);
    }

    public boolean isSassTemplateDefault() {
        return sassTemplateFile.equals(defaultSassTemplateFile);
    }

    public boolean isSpecTemplateDefault() {
        return specTemplateFile.equals(defaultSpecTemplateFile);
    }

    public boolean isStoryTemplateDefault() {
        return storyTemplateFile.equals(defaultStoryTemplateFile);
    }

    public boolean isMDTemplateDefault() {
        return markdownTemplateFile.equals(defaultMarkdownTemplateFile);
    }

    public void setCreateSassFile(Boolean createSassFile) {
        isCreateSassFile = createSassFile;
    }

    public void setCreateSpecFile(Boolean createSpecFile) {
        isCreateSpecFile = createSpecFile;
    }

    public void setCreateStoryFile(Boolean createStoryFile) {
        isCreateStoryFile = createStoryFile;
    }

    public void setCreateMDFile(Boolean createMDFile) {
        isCreateMDFile = createMDFile;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentTemplateFile() {
        return componentTemplateFile;
    }

    public String getSassTemplateFile() {
        return sassTemplateFile;
    }

    public String getSpecTemplateFile() {
        return specTemplateFile;
    }

    public String getStoryTemplateFile() {
        return storyTemplateFile;
    }

    public String getMarkdownTemplateFile() {
        return markdownTemplateFile;
    }

    public boolean isCreateStorybookDefaultChecked() {
        return isCreateStorybookDefaultChecked;
    }

    public boolean isCreateSpecDefaultChecked() {
        return isCreateSpecDefaultChecked;
    }

    public boolean isCreateScssDefaultChecked() {
        return isCreateScssDefaultChecked;
    }

    public boolean isCreateMarkdownDefaultChecked() {
        return isCreateMarkdownDefaultChecked;
    }

    public void setCreateStorybookDefaultChecked(boolean createStorybookDefaultChecked) {
        isCreateStorybookDefaultChecked = createStorybookDefaultChecked;
    }

    public void setCreateSpecDefaultChecked(boolean createSpecDefaultChecked) {
        isCreateSpecDefaultChecked = createSpecDefaultChecked;
    }

    public void setCreateScssDefaultChecked(boolean createScssDefaultChecked) {
        isCreateScssDefaultChecked = createScssDefaultChecked;
    }

    public void setCreateMarkdownDefaultChecked(boolean createMarkdownDefaultChecked) {
        isCreateMarkdownDefaultChecked = createMarkdownDefaultChecked;
    }

    public boolean equals(ComponentCreateOptions options) {
        return (options.getComponentTemplateFile().equals(componentTemplateFile)
                && options.getStoryTemplateFile().equals(storyTemplateFile)
                && options.getSpecTemplateFile().equals(specTemplateFile)
                && options.getSassTemplateFile().equals(sassTemplateFile)
                && options.getMarkdownTemplateFile().equals(markdownTemplateFile)
                && options.isCreateMarkdownDefaultChecked() == isCreateMarkdownDefaultChecked
                && options.isCreateScssDefaultChecked() == isCreateScssDefaultChecked
                && options.isCreateSpecDefaultChecked() == isCreateSpecDefaultChecked
                && options.isCreateStorybookDefaultChecked() == isCreateStorybookDefaultChecked
        );
    }
}
