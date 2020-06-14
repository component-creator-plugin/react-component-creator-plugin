package fabs.react.component.ui;

import fabs.react.component.data.ComponentCreateOptions;
import fabs.util.AbstractDialog;

import javax.swing.*;
import java.awt.event.*;

public class CreateComponentForm extends AbstractDialog<ComponentCreateOptions> {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox storybookCheckBox;
    private JCheckBox unitTestCheckBox;
    private JCheckBox SCSSCheckBox;
    private JCheckBox markdownCheckBox;

    public CreateComponentForm(ComponentCreateOptions options) {
        super(options);
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

        storybookCheckBox.setSelected(options.isCreateStorybookDefaultChecked());
        unitTestCheckBox.setSelected(options.isCreateSpecDefaultChecked());
        SCSSCheckBox.setSelected(options.isCreateScssDefaultChecked());
        markdownCheckBox.setSelected(options.isCreateMarkdownDefaultChecked());
    }

    @Override
    protected void onOK() {
        options.setComponentName(componentNameTextField.getText());
        options.setCreateStoryFile(storybookCheckBox.isSelected());
        options.setCreateSpecFile(unitTestCheckBox.isSelected());
        options.setCreateSassFile(SCSSCheckBox.isSelected());
        options.setCreateMDFile(markdownCheckBox.isSelected());
        super.onOK();
    }

    public String getComponentName() {
        return componentNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return componentNameTextField.getText();
    }
}
