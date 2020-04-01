package fabs.component.action;

import com.intellij.openapi.project.Project;
import fabs.component.ui.CreateComponentForm;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        return new CreateComponentForm();
    }
}
