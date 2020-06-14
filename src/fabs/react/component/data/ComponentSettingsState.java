package fabs.react.component.data;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import fabs.util.AbstractPersistentState;

@State(
        name = "ComponentSettings",
        storages = {
                @Storage("/rcc.xml")
        }
)
public class ComponentSettingsState extends AbstractPersistentState<ComponentCreateOptions> {

    public ComponentSettingsState() {
        super(new ComponentCreateOptions());
    }

    public static ComponentSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, ComponentSettingsState.class);
    }
}
