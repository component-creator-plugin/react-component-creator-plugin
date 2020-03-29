package fabs.component;

import fabs.util.AbstractDialog;
import fabs.util.StringFormatter;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreatorDialog extends AbstractDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox storybookCheckBox;
    private JCheckBox unitTestCheckBox;
    private JCheckBox SCSSCheckBox;
    private JCheckBox markdownCheckBox;

    private final String componentTemplateFile = "templates/component/component.tsx.mustache";
    private final String sassTemplateFile = "templates/component/_component.scss.mustache";
    private final String specTemplateFile = "templates/component/component.spec.tsx.mustache";
    private final String storyTemplateFile = "templates/component/component.story.tsx.mustache";
    private final String markdownTemplateFile = "templates/component/component.md.mustache";

    public ComponentCreatorDialog() {
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

    public Map<String, Object> getTemplateVars() {
        Map<String, Object> templateModel = new HashMap<>();
        String componentName = componentNameTextField.getText();

        templateModel.put("componentName", componentName);
        templateModel.put("componentCamelcaseName", StringFormatter.toCamelCase(componentName));

        return templateModel;
    }

    public String getComponentName() {
        return componentNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return componentNameTextField.getText();
    }

    public ArrayList<String> getFiles() {
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
