package fabs.component.settings;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import fabs.component.data.ComponentCreateOptions;
import fabs.component.ui.SettingsForm;
import fabs.component.data.ComponentSettingsState;
import fabs.util.AbstractSettingsUI;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ComponentSettings extends AbstractSettingsUI<ComponentCreateOptions> {
    private SettingsForm ui;

    public ComponentSettings(Project project) {
        super(project);
    }

    @Override
    public ComponentCreateOptions getOptions() {
        return ComponentSettingsState.getInstance(project).getOptions();
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Component";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (ui == null) {
            ui = new SettingsForm();
        }
        reset();

        return ui.getMainPanel();
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {
        ui.applySettings(getOptions());
    }
}
