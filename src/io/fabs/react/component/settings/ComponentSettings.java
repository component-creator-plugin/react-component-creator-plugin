package io.fabs.react.component.settings;

import com.intellij.openapi.project.Project;
import io.fabs.react.component.data.ComponentCreateOptions;
import io.fabs.react.component.ui.SettingsForm;
import io.fabs.react.component.data.ComponentSettingsState;
import io.fabs.util.settings.AbstractSettingsForm;
import io.fabs.util.settings.AbstractSettingsUI;

public class ComponentSettings extends AbstractSettingsUI<ComponentCreateOptions> {

    public ComponentSettings(Project project) {
        super(project, "Component");
    }

    @Override
    public ComponentCreateOptions getOptions() {
        return ComponentSettingsState.getInstance(project).getOptions();
    }

    @Override
    public AbstractSettingsForm createUi() {
        return new SettingsForm(getOptions());
    }
}
