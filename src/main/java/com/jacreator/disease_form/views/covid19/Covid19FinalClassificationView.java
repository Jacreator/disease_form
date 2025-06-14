package com.jacreator.disease_form.views.covid19;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class Covid19FinalClassificationView extends VerticalLayout {
private RadioButtonGroup<String> finalClassification;

    public Covid19FinalClassificationView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();

        finalClassification = new RadioButtonGroup<>("Final classification");
        finalClassification.setItems("Confirmed", "Not a Case", "Probable", "Pending", "Not Done");
        finalClassification.setRequired(true);
        finalClassification.setRequiredIndicatorVisible(true);

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));
        form.add(finalClassification);

        return form;
    }
}
