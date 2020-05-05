package fabs.reducer.action;

import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerSettingsState;
import fabs.reducer.ui.CreateReducerForm;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class ReducerCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        ReducerSettingsState state = ReducerSettingsState.getInstance(project);
        return new CreateReducerForm(state.getOptions());
    }
}
