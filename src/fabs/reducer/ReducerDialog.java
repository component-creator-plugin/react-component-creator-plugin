package fabs.reducer;

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


    private final String actionTemplateFile = "templates/reducer/actions.ts.mustache";
    private final String indexTemplateFile = "templates/reducer/index.ts.mustache";
    private final String typesTemplateFile = "templates/reducer/types.ts.mustache";
    private final String actionTypesTemplateFile = "templates/reducer/action-types.ts.mustache";

    public ReducerDialog() {
        setContentPane(contentPanel);
        setModal(true);
        getRootPane().setDefaultButton(createButton);

        createButton.addActionListener(e -> onOK());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPanel.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();

        files.add(actionTemplateFile);
        files.add(indexTemplateFile);
        files.add(typesTemplateFile);
        files.add(actionTypesTemplateFile);

        return files;
    }

    @Override
    public Map<String, Object> getTemplateVars() {
        Map<String, Object> templateModel = new HashMap<>();
        String actionFunctionName = actionNameTextField.getText();

        templateModel.put("actionFunctionName", actionFunctionName);
        templateModel.put("moduleName", StringFormatter.toCamelCase(moduleNameTextField.getText()));
        templateModel.put("moduleNamePascalCase", StringFormatter.toCamelCase(moduleNameTextField.getText()));
        templateModel.put("stateName", StringFormatter.toCamelCase(moduleNameTextField.getText()) + "State");
        templateModel.put("mutationType", mutationNametextField.getText());
        templateModel.put("actionTypeName", StringFormatter.capitalizeFirst(actionFunctionName)+"Action");

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
