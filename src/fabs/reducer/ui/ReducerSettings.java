package fabs.reducer.ui;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import fabs.reducer.state.ReducerSettingsState;
import fabs.reducer.ui.settings.ReducerSettingsUI;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ReducerSettings implements Configurable {
    private ReducerSettingsUI ui;
    private Project currentProject;

    public ReducerSettings(Project project) {
        currentProject = project;
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
            ui = new ReducerSettingsUI(getState().getOptions());
        }
        reset();

        return ui.getMainPanel();
    }

    private ReducerSettingsState getState() {
        return ReducerSettingsState.getInstance(currentProject);
    }

    @Override
    public boolean isModified() {
        return ui.isDirty();
    }

    @Override
    public void apply() throws ConfigurationException {
        ui.applySettings(getState().getOptions());
    }
}
