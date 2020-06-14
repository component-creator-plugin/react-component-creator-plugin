package fabs.react.reducer.settings;

import com.intellij.openapi.project.Project;
import fabs.react.reducer.data.ReducerCreateOptions;
import fabs.react.reducer.data.ReducerSettingsState;
import fabs.react.reducer.ui.SettingsForm;
import fabs.util.AbstractSettingsForm;
import fabs.util.AbstractSettingsUI;

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
