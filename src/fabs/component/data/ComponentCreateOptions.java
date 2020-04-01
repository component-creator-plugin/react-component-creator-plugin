package fabs.component.data;

import fabs.util.SerializableOptions;
import org.jdom.Element;

public class ComponentCreateOptions implements SerializableOptions {
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

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(COMPONENT_TEMPLATE_KEY, componentTemplateFile);
        element.setAttribute(SASS_TEMPLATE_KEY, sassTemplateFile);
        element.setAttribute(SPEC_TEMPLATE_KEY, specTemplateFile);
        element.setAttribute(STORY_TEMPLATE_KEY, storyTemplateFile);
        element.setAttribute(MD_TEMPLATE_KEY, markdownTemplateFile);
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setSassTemplateFile(element.getAttributeValue(SASS_TEMPLATE_KEY));
        setSpecTemplateFile(element.getAttributeValue(SPEC_TEMPLATE_KEY));
        setStoryTemplateFile(element.getAttributeValue(STORY_TEMPLATE_KEY));
        setMarkdownTemplateFile(element.getAttributeValue(MD_TEMPLATE_KEY));
    }

    public String getComponentTemplateFile() {
        return componentTemplateFile;
    }

    public void setComponentTemplateFile(String componentTemplateFile) {
        if (componentTemplateFile == null || componentTemplateFile.isEmpty()) {
            this.componentTemplateFile = defaultComponentTemplateFile;
            return;
        }
        this.componentTemplateFile = componentTemplateFile;
    }

    public String getSassTemplateFile() {
        return sassTemplateFile;
    }

    public void setSassTemplateFile(String sassTemplateFile) {
        if (sassTemplateFile == null || sassTemplateFile.isEmpty()) {
            this.sassTemplateFile = defaultSassTemplateFile;
            return;
        }
        this.sassTemplateFile = sassTemplateFile;
    }

    public String getSpecTemplateFile() {
        return specTemplateFile;
    }

    public void setSpecTemplateFile(String specTemplateFile) {
        if (specTemplateFile == null || specTemplateFile.isEmpty()) {
            this.specTemplateFile = defaultSpecTemplateFile;
            return;
        }
        this.specTemplateFile = specTemplateFile;
    }

    public String getStoryTemplateFile() {
        return storyTemplateFile;
    }

    public void setStoryTemplateFile(String storyTemplateFile) {
        if (storyTemplateFile == null || storyTemplateFile.isEmpty()) {
            this.storyTemplateFile = defaultStoryTemplateFile;
            return;
        }
        this.storyTemplateFile = storyTemplateFile;
    }

    public String getMarkdownTemplateFile() {
        return markdownTemplateFile;
    }

    public void setMarkdownTemplateFile(String markdownTemplateFile) {
        if (markdownTemplateFile == null || markdownTemplateFile.isEmpty()) {
            this.markdownTemplateFile = defaultMarkdownTemplateFile;
            return;
        }
        this.markdownTemplateFile = markdownTemplateFile;
    }
}
