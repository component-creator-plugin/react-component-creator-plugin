package fabs.reducer.ui;

import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerCreateOptions;
import fabs.util.AbstractDialog;
import fabs.util.StringFormatter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReducerDialog extends AbstractDialog {

    private JPanel contentPanel;
    private JTextField moduleNameTextField;
    private JTextField actionNameTextField;
    private JButton createButton;
    private JTextField mutationNametextField;
    private ReducerCreateOptions options;

    public ReducerDialog(ReducerCreateOptions options) {
        this.options = options;
        setContentPane(contentPanel);
        setModal(true);
        getRootPane().setDefaultButton(createButton);

        createButton.addActionListener(e -> onOK());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPanel.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    @Override
    public ArrayList<String> getFiles(Project project) {
        return options.getFiles();
    }

    @Override
    public Map<String, Object> getTemplateVars() {
        Map<String, Object> templateModel = new HashMap<>();
        String actionFunctionName = actionNameTextField.getText();
        String moduleName = moduleNameTextField.getText();

        templateModel.put("actionFunctionName", actionFunctionName);
        templateModel.put("moduleName", moduleName);
         templateModel.put("moduleNamePascalCase", StringFormatter.toCamelCase(moduleName));
        templateModel.put("stateName", StringFormatter.toCamelCase(moduleName) + "State");
        templateModel.put("mutationType", mutationNametextField.getText());
        templateModel.put("actionTypeName", StringFormatter.capitalizeFirst(actionFunctionName) + "Action");
        templateModel.put("actionTypesEnumName", StringFormatter.toDashCase(moduleName).toUpperCase() + "_ACTIONS");

        return templateModel;
    }

    @Override
    public String getComponentName() {
        return "";
    }

    public String getDirectoryName() {
        return moduleNameTextField.getText();
    }
}
