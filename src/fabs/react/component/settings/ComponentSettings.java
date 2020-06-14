package fabs.react.component.settings;

import com.intellij.openapi.project.Project;
import fabs.react.component.data.ComponentCreateOptions;
import fabs.react.component.ui.SettingsForm;
import fabs.react.component.data.ComponentSettingsState;
import fabs.util.AbstractSettingsForm;
import fabs.util.AbstractSettingsUI;

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
