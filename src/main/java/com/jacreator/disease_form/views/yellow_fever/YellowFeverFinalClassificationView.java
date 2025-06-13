package com.jacreator.disease_form.views.yellow_fever;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class YellowFeverFinalClassificationView extends VerticalLayout {
public YellowFeverFinalClassificationView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Final classification
        RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
        finalClassification.setLabel("What is the final classification of the case?");
        finalClassification.setItems("Pending", "Confirmed", "Presumptive positive", "Discarded");
        finalClassification.setRequired(true);

        // Diagnosis (conditional)
        TextField diagnosis = new TextField("Enter diagnosis");
        diagnosis.setPlaceholder("Enter diagnosis");
        diagnosis.setRequired(true);
        diagnosis.setVisible(false);

        // Show/hide diagnosis field based on finalClassification
        finalClassification.addValueChangeListener(e -> {
            boolean show = "Discarded".equalsIgnoreCase(e.getValue());
            diagnosis.setVisible(show);
        });

        // Add fields to the form
        form.add(finalClassification, diagnosis);

        return form;
    }
}
