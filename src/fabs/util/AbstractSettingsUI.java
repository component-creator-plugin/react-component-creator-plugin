package fabs.util;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;

public abstract class AbstractSettingsUI<T extends SerializableOptions> implements Configurable {
    protected Project project;

    public AbstractSettingsUI(Project project) {
        this.project = project;
    }

    public abstract T getOptions();
}
