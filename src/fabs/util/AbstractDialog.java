package fabs.util;

import com.intellij.openapi.project.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractDialog extends JDialog {

    public abstract ArrayList<String> getFiles(Project project);

    public abstract VariableHolder getVariables();

    public abstract String getComponentName();

    public abstract String getDirectoryName();

    protected boolean hasCanceled = false;

    public boolean isCanceled() {
        return hasCanceled;
    }

    protected void onOK() {
        hasCanceled = false;
        dispose();
    }

    protected void onCancel() {
        hasCanceled = true;
        dispose();
    }
}
