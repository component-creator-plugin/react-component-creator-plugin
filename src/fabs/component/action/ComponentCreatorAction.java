package fabs.component.action;

import com.intellij.openapi.project.Project;
import fabs.component.data.ComponentSettingsState;
import fabs.component.ui.CreateComponentForm;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        ComponentSettingsState state = ComponentSettingsState.getInstance(project);
        return new CreateComponentForm(state.getOptions());
    }
}
