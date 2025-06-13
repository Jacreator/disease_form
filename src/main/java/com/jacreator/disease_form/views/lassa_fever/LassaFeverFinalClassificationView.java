package com.jacreator.disease_form.views.lassa_fever;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class LassaFeverFinalClassificationView extends VerticalLayout {
public LassaFeverFinalClassificationView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Final classification options
        RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
        finalClassification.setLabel("Final classification");
        finalClassification.setItems(
            "Laboratory confirmed",
            "Probable",
            "Not a case",
            "Pending"
        );
        finalClassification.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2)
        );

        // Add field to the form
        form.add(finalClassification);

        return form;
    }
}
