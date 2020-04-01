package fabs.reducer.ui;

import fabs.reducer.data.ReducerCreateOptions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SettingsForm {
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

    public SettingsForm(ReducerCreateOptions options) {
        this.options = options;
        fileChooser = new JFileChooser();

        // Set default settings received from state
        if (!options.isActionTypesTemplateDefault()) {
            actionTypesTemplateInput.setText(options.getActionTypesTemplateFile());
        }

        if (!options.isActionTemplateDefault()) {
            actionsTemplateInput.setText(options.getActionTemplateFile());
        }

        if (!options.isModuleTemplateDefault()) {
            indexTemplateInput.setText(options.getModuleIndexTemplateFile());
        }

        if (!options.isTypesTemplateDefault()) {
            typesTemplateInput.setText(options.getTypesTemplateFile());
        }

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
        String actionTypes = actionTypesTemplateInput.getText();
        String actions = actionsTemplateInput.getText();
        String index = indexTemplateInput.getText();
        String types = typesTemplateInput.getText();

        if (actionTypes != null) {
            options.setActionTypesTemplateFile(actionTypes);
        }

        if (actions != null) {
            options.setActionTemplateFile(actions);
        }

        if (index != null) {
            options.setModuleIndexTemplateFile(index);
        }

        if (types != null) {
            options.setTypesTemplateFile(types);
        }
    }

    /**
     * Define whether the state is dirty or not
     */
    public boolean isDirty() {
        return !(
                options.getActionTypesTemplateFile().equals(actionTypesTemplateInput.getText())
                        && options.getActionTemplateFile().equals(actionsTemplateInput.getText())
                        && options.getModuleIndexTemplateFile().equals(indexTemplateInput.getText())
                        && options.getTypesTemplateFile().equals(typesTemplateInput.getText())
        );
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }
}
