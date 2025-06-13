package com.jacreator.disease_form.views.csm;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class CSMFinalClassificationView extends VerticalLayout {
private RadioButtonGroup<String> finalClassification;

    public CSMFinalClassificationView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1)
        );

        finalClassification = new RadioButtonGroup<>("Final classification");
        finalClassification.setItems(
                "laboratory confirmed",
                "epidemiology link",
                "clinically compatible",
                "probable",
                "not a case/discarded",
                "pending"
        );
        finalClassification.setRequired(true);
        finalClassification.setRequiredIndicatorVisible(true);

        form.add(finalClassification);

        return form;
    }
}
