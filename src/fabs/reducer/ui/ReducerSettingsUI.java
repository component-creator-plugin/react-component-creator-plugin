package fabs.reducer.ui;

import fabs.reducer.data.ReducerCreateOptions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReducerSettingsUI {
    private JPanel mainPanel;
    private JTextField actionTypesTemplateInput;
    private JButton actionTypesTemplateButton;
    private JTextField actionsTemplateInput;
    private JButton actionsTemplateBtn;
    private JTextField indexTemplateInput;
    private JTextField typesTemplateInput;
    private JButton indexTemplateBtn;
    private JButton typesTemplateBtn;
    private ReducerCreateOptions options;
    private JFileChooser fileChooser;

    public ReducerSettingsUI(ReducerCreateOptions options) {
        this.options = options;
        fileChooser = new JFileChooser();

        // Set default settings received from state
        actionTypesTemplateInput.setText(options.getActionTypesTemplateFile());
        actionsTemplateInput.setText(options.getActionTemplateFile());
        indexTemplateInput.setText(options.getModuleIndexTemplateFile());
        typesTemplateInput.setText(options.getTypesTemplateFile());

        // Add listeners for browse button
        actionTypesTemplateButton.addActionListener(e -> onBrowseButtonClicked(e, actionTypesTemplateInput));
        actionsTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, actionsTemplateInput));
        indexTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, indexTemplateInput));
        typesTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, typesTemplateInput));
    }

    /**
     * Handle browse button clicks
     */
    private void onBrowseButtonClicked(ActionEvent e, JTextField input) {
        if (fileChooser.showOpenDialog(getMainPanel()) == JFileChooser.APPROVE_OPTION) {
            input.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    /**
     * Apply inputfield values to option object to be persisted in state
     */
    public void applySettings(ReducerCreateOptions options) {
        options.setActionTypesTemplateFile(actionTypesTemplateInput.getText());
        options.setActionTemplateFile(actionsTemplateInput.getText());
        options.setModuleIndexTemplateFile(indexTemplateInput.getText());
        options.setTypesTemplateFile(typesTemplateInput.getText());
    }

    /**
     * Define whether the state is dirty or not
     */
    public boolean isDirty() {
        return !(options.getActionTypesTemplateFile() == actionTypesTemplateInput.getText() &&
                options.getActionTemplateFile() == actionsTemplateInput.getText());
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }
}
