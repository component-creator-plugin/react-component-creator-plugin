package fabs.component;

import com.intellij.openapi.project.Project;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    @Override
    protected AbstractDialog createDialog(Project project) {
        return new ComponentCreatorDialog();
    }
}
