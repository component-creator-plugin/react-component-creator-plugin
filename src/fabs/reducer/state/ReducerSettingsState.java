package fabs.reducer.state;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerCreateOptions;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "ReducerSettings",
        storages = {
                @Storage("/rcc.xml")
        }
)
public class ReducerSettingsState implements PersistentStateComponent<Element> {
    public static final String STORE_KEY = "ReducerSettings";

    private ReducerCreateOptions reducerCreateOptions;
    private final static String ACTION_TEMPLATE = "ACTION_TEMPLATE";
    private final static String ACTION_TYPES_TEMPLATE = "ACTION_TYPES_TEMPLATE";
    private final static String INDEX_TEMPLATE = "INDEX_TEMPLATE";
    private final static String TYPES_TEMPLATE = "ACTION_TEMPLATE";

    public ReducerSettingsState() {
        this.reducerCreateOptions = new ReducerCreateOptions();
    }

    @Nullable
    @Override
    /**
     * Called when the state has to be persisted
     */
    public Element getState() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(ACTION_TEMPLATE, reducerCreateOptions.getActionTemplateFile());
        element.setAttribute(ACTION_TYPES_TEMPLATE, reducerCreateOptions.getActionTypesTemplateFile());
        element.setAttribute(INDEX_TEMPLATE, reducerCreateOptions.getModuleIndexTemplateFile());
        element.setAttribute(TYPES_TEMPLATE, reducerCreateOptions.getTypesTemplateFile());
        return element;
    }

    @Override
    /**
     * Called when the settings start, and the data is loaded from store
     */
    public void loadState(@NotNull Element element) {
        reducerCreateOptions.setActionTemplateFile(element.getAttributeValue(ACTION_TEMPLATE));
        reducerCreateOptions.setActionTypesTemplateFile(element.getAttributeValue(ACTION_TYPES_TEMPLATE));
        reducerCreateOptions.setModuleIndexTemplateFile(element.getAttributeValue(INDEX_TEMPLATE));
        reducerCreateOptions.setTypesTemplateFile(element.getAttributeValue(TYPES_TEMPLATE));
    }

    /**
     * Make state available for project context
     */
    public static ReducerSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, ReducerSettingsState.class);
    }

    public ReducerCreateOptions getReducerCreateOptions() {
        return reducerCreateOptions;
    }
}
