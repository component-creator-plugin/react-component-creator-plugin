package fabs.react.reducer.ui;

import fabs.react.reducer.data.ReducerCreateOptions;
import fabs.util.AbstractSettingsForm;

import javax.swing.*;

public class SettingsForm extends AbstractSettingsForm<ReducerCreateOptions> {
    private JPanel mainPanel;
    private JTextField actionTypesTemplateInput;
    private JButton actionTypesTemplateButton;
    private JTextField actionsTemplateInput;
    private JButton actionsTemplateBtn;
    private JTextField indexTemplateInput;
    private JTextField typesTemplateInput;
    private JButton indexTemplateBtn;
    private JButton typesTemplateBtn;

    public SettingsForm(ReducerCreateOptions options) {
        super(options);

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

    @Override
    public JComponent getMainPanel() {
        return this.mainPanel;
    }

    public boolean isDirty() {
        ReducerCreateOptions o = new ReducerCreateOptions();
        o.setActionTypesTemplateFile(actionTypesTemplateInput.getText());
        o.setActionTemplateFile(actionsTemplateInput.getText());
        o.setModuleIndexTemplateFile(indexTemplateInput.getText());
        o.setTypesTemplateFile(typesTemplateInput.getText());
        return !options.equals(o);
    }

    @Override
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

}
