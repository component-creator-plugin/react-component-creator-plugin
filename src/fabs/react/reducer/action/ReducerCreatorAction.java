package fabs.react.reducer.action;

import com.intellij.openapi.project.Project;
import fabs.react.reducer.data.ReducerSettingsState;
import fabs.react.reducer.ui.CreateReducerForm;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class ReducerCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        ReducerSettingsState state = ReducerSettingsState.getInstance(project);
        return new CreateReducerForm(state.getOptions());
    }
}
