package io.fabs.react.component.action;

import com.intellij.openapi.project.Project;
import io.fabs.react.component.data.ComponentSettingsState;
import io.fabs.react.component.ui.CreateComponentForm;
import io.fabs.util.AbstractCreatorAction;
import io.fabs.util.AbstractDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        ComponentSettingsState state = ComponentSettingsState.getInstance(project);
        return new CreateComponentForm(state.getOptions());
    }
}
