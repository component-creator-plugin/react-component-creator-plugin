package fabs.react.reducer.data;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import fabs.util.AbstractPersistentState;

@State(
        name = "ReducerSettings",
        storages = {
                @Storage("/rcc.xml")
        }
)
public class ReducerSettingsState extends AbstractPersistentState<ReducerCreateOptions> {

    public ReducerSettingsState() {
        super(new ReducerCreateOptions());
    }

    public static ReducerSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, ReducerSettingsState.class);
    }
}
