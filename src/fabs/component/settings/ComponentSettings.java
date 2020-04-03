package fabs.component.settings;

import com.intellij.openapi.project.Project;
import fabs.component.data.ComponentCreateOptions;
import fabs.component.ui.SettingsForm;
import fabs.component.data.ComponentSettingsState;
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
