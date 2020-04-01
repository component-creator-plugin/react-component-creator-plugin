package fabs.reducer.ui;

import com.intellij.openapi.project.Project;
import fabs.reducer.data.ReducerCreateOptions;
import fabs.reducer.data.ReducerVariables;
import fabs.util.AbstractDialog;
import fabs.util.VariableHolder;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
    public VariableHolder getVariables() {
        String actionFunctionName = actionNameTextField.getText();
        String moduleName = moduleNameTextField.getText();

        return new ReducerVariables(actionFunctionName, moduleName, mutationNametextField.getText());
    }

    @Override
    public String getComponentName() {
        return "";
    }

    public String getDirectoryName() {
        return moduleNameTextField.getText();
    }
}
