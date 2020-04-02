package fabs.util;

import com.intellij.openapi.project.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractDialog<T extends AbstractOptions> extends JDialog {
    protected T options;

    public AbstractDialog(T options) {
        super();
        this.options = options;
    }

    public abstract String getComponentName();

    public abstract String getDirectoryName();

    protected boolean hasCanceled = false;

    public ArrayList<String> getFiles() throws Exception {
        ArrayList<String> files = options.getFiles();
        if (files.size() <= 0) {
            throw new Exception("At least one file is required");
        }
        return files;
    }

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

    public T getOptions() {
        return options;
    }
}
