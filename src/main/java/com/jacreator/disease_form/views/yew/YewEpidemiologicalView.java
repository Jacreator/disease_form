package com.jacreator.disease_form.views.yew;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class YewEpidemiologicalView extends VerticalLayout {
public YewEpidemiologicalView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Duration of illness (weeks)
        TextField duration = new TextField("Duration of illness(weeks)");
        duration.setPlaceholder("Duration of illness(weeks)");

        // Previous treatments (if any)
        TextField previousTreatments = new TextField("Previous treatments(if any)");
        previousTreatments.setPlaceholder("Previous treatments(if any)");

        // Travel History
        TextField travelHistory = new TextField("Travel History");
        travelHistory.setPlaceholder("Travel History");

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));
        // Add all fields to the form
        form.add(duration, previousTreatments, travelHistory);

        return form;
    }
}
