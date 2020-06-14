package fabs.react.reducer.ui;

import fabs.react.reducer.data.ReducerCreateOptions;
import fabs.util.AbstractDialog;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateReducerForm extends AbstractDialog<ReducerCreateOptions> {

    private JPanel contentPanel;
    private JTextField moduleNameTextField;
    private JTextField actionNameTextField;
    private JButton createButton;
    private JTextField mutationNametextField;

    public CreateReducerForm(ReducerCreateOptions options) {
        super(options);
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
    public String getComponentName() {
        return "";
    }

    public String getDirectoryName() {
        return moduleNameTextField.getText();
    }

    @Override
    protected void onOK() {
        options.setActionFunctionName(actionNameTextField.getText());
        options.setModuleName(moduleNameTextField.getText());
        options.setMutationType(mutationNametextField.getText());
        super.onOK();
    }
}
