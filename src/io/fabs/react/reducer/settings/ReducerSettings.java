package io.fabs.react.reducer.settings;

import com.intellij.openapi.project.Project;
import io.fabs.react.reducer.data.ReducerCreateOptions;
import io.fabs.react.reducer.data.ReducerSettingsState;
import io.fabs.react.reducer.ui.SettingsForm;
import io.fabs.util.settings.AbstractSettingsForm;
import io.fabs.util.settings.AbstractSettingsUI;

public class ReducerSettings extends AbstractSettingsUI<ReducerCreateOptions> {
    public ReducerSettings(Project project) {
        super(project, "Redux Reducer");
    }

    @Override
    public ReducerCreateOptions getOptions() {
        return ReducerSettingsState.getInstance(project).getOptions();
    }

    @Override
    public AbstractSettingsForm createUi() {
        return new SettingsForm(getOptions());
    }

}
