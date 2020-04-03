package fabs.component.ui;

import fabs.component.data.ComponentCreateOptions;
import fabs.util.AbstractSettingsForm;

import javax.swing.*;

public class SettingsForm extends AbstractSettingsForm<ComponentCreateOptions> {
    private JPanel mainPanel;
    private JTextField componentTemplateInput;
    private JTextField storyTemplateInput;
    private JTextField specTemplateInput;
    private JTextField scssTemplateInput;
    private JTextField mdTemplateInput;

    private JButton componentTemplateBtn;
    private JButton storyTemplateBtn;
    private JButton specTemplateBtn;
    private JButton scssTemplateBtn;
    private JButton mdTemplateBtn;

    public SettingsForm(ComponentCreateOptions options) {
        super(options);

        if (!options.isComponentTemplateDefault()) {
            componentTemplateInput.setText(options.getComponentTemplateFile());
        }

        if (!options.isStoryTemplateDefault()) {
            storyTemplateInput.setText(options.getStoryTemplateFile());
        }

        if (!options.isSpecTemplateDefault()) {
            specTemplateInput.setText(options.getSpecTemplateFile());
        }

        if (!options.isSassTemplateDefault()) {
            scssTemplateInput.setText(options.getSassTemplateFile());
        }

        if (!options.isMDTemplateDefault()) {
            mdTemplateInput.setText(options.getMarkdownTemplateFile());
        }

        componentTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, componentTemplateInput));
        storyTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, storyTemplateInput));
        specTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, specTemplateInput));
        scssTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, scssTemplateInput));
        mdTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, mdTemplateInput));
    }

    @Override
    public JComponent getMainPanel() {
        return mainPanel;
    }

    @Override
    public boolean isDirty() {
        ComponentCreateOptions o = new ComponentCreateOptions();
        o.setComponentTemplateFile(componentTemplateInput.getText());
        o.setSassTemplateFile(scssTemplateInput.getText());
        o.setSpecTemplateFile(specTemplateInput.getText());
        o.setStoryTemplateFile(storyTemplateInput.getText());
        o.setMarkdownTemplateFile(mdTemplateInput.getText());
        return !options.equals(o);
    }

    public void applySettings(ComponentCreateOptions options) {
        String component = componentTemplateInput.getText();
        String story = storyTemplateInput.getText();
        String spec = specTemplateInput.getText();
        String scss = scssTemplateInput.getText();
        String md = mdTemplateInput.getText();

        if (!component.isEmpty()) {
            options.setComponentTemplateFile(component);
        }

        if (!story.isEmpty()) {
            options.setStoryTemplateFile(story);
        }

        if (!spec.isEmpty()) {
            options.setSpecTemplateFile(spec);
        }

        if (!scss.isEmpty()) {
            options.setSassTemplateFile(scss);
        }

        if (!md.isEmpty()) {
            options.setMarkdownTemplateFile(md);
        }
    }
}
