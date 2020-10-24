package io.fabs.react.reducer.action;

import com.intellij.openapi.project.Project;
import io.fabs.react.reducer.data.ReducerSettingsState;
import io.fabs.react.reducer.ui.CreateReducerForm;
import io.fabs.util.AbstractCreatorAction;
import io.fabs.util.AbstractDialog;

public class ReducerCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        ReducerSettingsState state = ReducerSettingsState.getInstance(project);
        return new CreateReducerForm(state.getOptions());
    }
}
