package fabs.reducer.settings;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerCreateOptions;
import fabs.reducer.data.ReducerSettingsState;
import fabs.reducer.ui.SettingsForm;
import fabs.util.AbstractSettingsUI;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ReducerSettings extends AbstractSettingsUI<ReducerCreateOptions> {
    private SettingsForm ui;

    public ReducerSettings(Project project) {
        super(project);
    }


    @Override
    public ReducerCreateOptions getOptions() {
        return ReducerSettingsState.getInstance(project).getOptions();
    }

    /**
     * Name used for settings
     */
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Redux Reducer";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (ui == null) {
            ui = new SettingsForm(getOptions());
        }
        reset();

        return ui.getMainPanel();
    }


    @Override
    public boolean isModified() {
        return ui.isDirty();
    }

    @Override
    public void apply() throws ConfigurationException {
        ui.applySettings(getOptions());
    }
}
