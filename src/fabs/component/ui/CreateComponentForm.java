package fabs.component.ui;

import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerVariables;
import fabs.util.AbstractDialog;
import fabs.util.VariableHolder;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateComponentForm extends AbstractDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox storybookCheckBox;
    private JCheckBox unitTestCheckBox;
    private JCheckBox SCSSCheckBox;
    private JCheckBox markdownCheckBox;

    private final String componentTemplateFile = "templates/component/{{componentName}}.tsx.mustache";
    private final String sassTemplateFile = "templates/component/_{{componentName}}.scss.mustache";
    private final String specTemplateFile = "templates/component/{{componentName}}.spec.tsx.mustache";
    private final String storyTemplateFile = "templates/component/{{componentName}}.story.tsx.mustache";
    private final String markdownTemplateFile = "templates/component/{{componentName}}.md.mustache";

    public CreateComponentForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public VariableHolder getVariables() {
        return new ReducerVariables("", "", "");
    }

    public String getComponentName() {
        return componentNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return componentNameTextField.getText();
    }

    public ArrayList<String> getFiles(Project project) {
        ArrayList<String> files = new ArrayList<>();
        files.add(componentTemplateFile);

        if (storybookCheckBox.isSelected()) {
            files.add(storyTemplateFile);
        }

        if (markdownCheckBox.isSelected()) {
            files.add(markdownTemplateFile);
        }

        if (unitTestCheckBox.isSelected()) {
            files.add(specTemplateFile);
        }

        if (SCSSCheckBox.isSelected()) {
            files.add(sassTemplateFile);
        }

        return files;
    }
}
