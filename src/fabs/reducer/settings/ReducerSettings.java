package fabs.reducer.settings;

import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerCreateOptions;
import fabs.reducer.data.ReducerSettingsState;
import fabs.reducer.ui.SettingsForm;
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
