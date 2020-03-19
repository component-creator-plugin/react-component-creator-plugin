package fabs.component;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreatorDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField componentNameTextField;
    private JCheckBox storybookCheckBox;
    private JCheckBox unitTestCheckBox;
    private JCheckBox SCSSCheckBox;
    private JCheckBox SFCCheckBox;


    private final String componentTemplateFile = "templates/component/component.tsx.mustache";
    private final String sfcComponentTemplateFile = "templates/component/sfc/component.tsx.mustache";
    private final String sassTemplateFile = "templates/component/_component.scss.mustache";
    private final String specTemplateFile = "templates/component/component.spec.tsx.mustache";
    private final String storyTemplateFile = "templates/component/component.story.tsx.mustache";

    private boolean hasCanceled = false;

    public ComponentCreatorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    public Map<String, Object> getTemplateVars() {
        Map<String, Object> templateModel = new HashMap<String, Object>();
        templateModel.put("componentName", componentNameTextField.getText());
        return templateModel;
    }

    public String getComponentName() {
        return componentNameTextField.getText();
    }

    public String[] getFiles() {
        ArrayList<String> files = new ArrayList<String>();

        if (SFCCheckBox.isSelected()) {
            files.add(sfcComponentTemplateFile);
        } else {
            files.add(componentTemplateFile);
        }

        if (storybookCheckBox.isSelected()) {
            files.add(storyTemplateFile);
        }

        if (unitTestCheckBox.isSelected()) {
            files.add(specTemplateFile);
        }

        if (SCSSCheckBox.isSelected()) {
            files.add(sassTemplateFile);
        }

        return files.toArray(new String[files.size()]);
    }

    public boolean isCanceled() {
        return hasCanceled;
    }

    private void onOK() {
        hasCanceled = false;
        dispose();
    }

    private void onCancel() {
        hasCanceled = true;
        dispose();
    }

}
