package com.jacreator.disease_form.views.dengue;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class DengueFinalClassificationView extends VerticalLayout{
private RadioButtonGroup<String> finalClassification;

    public DengueFinalClassificationView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2)
        );

        finalClassification = new RadioButtonGroup<>("What is the final classification of the case?");
        finalClassification.setItems("suspect", "confirmed", "presumptive positive", "discarded");
        finalClassification.setRequired(true);
        finalClassification.setRequiredIndicatorVisible(true);

        form.add(finalClassification);

        return form;
    }
}
