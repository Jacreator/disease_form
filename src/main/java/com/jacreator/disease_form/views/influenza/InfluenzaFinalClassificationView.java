package com.jacreator.disease_form.views.influenza;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class InfluenzaFinalClassificationView extends VerticalLayout {
public InfluenzaFinalClassificationView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Final Classification options
        RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
        finalClassification.setLabel("Final Classification");
        finalClassification.setItems(
            "Confirmed",
            "Not a Case",
            "Probable",
            "Pending",
            "Not Done"
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
